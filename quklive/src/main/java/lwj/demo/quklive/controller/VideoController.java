package lwj.demo.quklive.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import lwj.demo.quklive.dto.QukMessageDTO;
import lwj.demo.quklive.dto.QukResponse;
import lwj.demo.quklive.dto.QukTransDTO;
import lwj.demo.quklive.dto.UrlInfoDTO;
import lwj.demo.quklive.dto.VideoAnalyseDTO;
import lwj.demo.quklive.dto.VideoTranscodeDTO;
import lwj.demo.quklive.utils.Base64Util;
import lwj.demo.quklive.utils.HmacSha1Util;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@Api(value = "趣看视频服务", description = "趣看视频服务")
@Slf4j
public class VideoController {

    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation(value = "接口趣看的消息", notes = "接口趣看的消息")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "", response = String.class) })
    @RequestMapping(path = "/quk/receive-message", method = RequestMethod.POST)
    public String receiveMessage(@RequestBody QukMessageDTO dto) {
        log.info("event:" + dto.getEvent());
        log.info("data:" + dto.getData());
        log.info("appKey:" + dto.getAppKey());
        log.info("nonce:" + dto.getNonce());
        log.info("signature:" + dto.getSignature());

        String content = "appKey=" + dto.getAppKey() + "&nonce=" + dto.getNonce();
        String appSecret = "71SYb04Cgx0Ap6FS";
        System.out.println("数据有效性：" + dto.getSignature()
                .equals(Base64Util.encode(HmacSha1Util.hamcsha1(content.getBytes(), appSecret.getBytes()))));

        JSONObject obj = null;
        switch (dto.getEvent()) {
            case "video_analyse":
                obj = JSONObject.fromObject(dto.getData());// 将json字符串转换为json对象
                VideoAnalyseDTO analyseData = (VideoAnalyseDTO) JSONObject.toBean(obj, VideoAnalyseDTO.class);// 将建json对象转换为Person对象
                log.info("analyseData:" + analyseData);

                HttpHeaders headers = new HttpHeaders();
                MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
                headers.setContentType(type);
                QukTransDTO param = new QukTransDTO();
                param.setVideoId(analyseData.getId());
                param.setDefinitionType(3);
                param.setFormat("mp4");
                JSONObject json = JSONObject.fromObject(param);
                String requestJson = json.toString();
                HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
                QukResponse response = restTemplate.postForObject("http://api.quklive.com/cloud/open/video/transcode",
                        entity, QukResponse.class);
                log.info("response:" + response);
                break;
            case "video_transcode":
                obj = JSONObject.fromObject(dto.getData());// 将json字符串转换为json对象
                JSONArray array = (JSONArray) obj.get("urlList");
                VideoTranscodeDTO transData = new VideoTranscodeDTO();
                transData.setId(obj.getLong("id"));
                transData.setOperateTime(obj.getLong("operateTime"));
                JSONObject urlInfo = null;
                List<UrlInfoDTO> urlList = new ArrayList<UrlInfoDTO>();
                for (int i = 0; i < array.size(); i++) {
                    urlInfo = JSONObject.fromObject(array.get(i));
                    UrlInfoDTO urlData = (UrlInfoDTO) JSONObject.toBean(urlInfo, UrlInfoDTO.class);
                    urlList.add(urlData);
                }
                transData.setUrlList(urlList);
                log.info("transData:" + transData);
                break;
            default:
                break;
        }
        return "success";
    }
}
