package lwj.demo.quklive.dto;

import lombok.Data;
import lwj.demo.quklive.utils.Base64Util;
import lwj.demo.quklive.utils.HmacSha1Util;
import net.sf.json.JSONObject;

@Data
public class QukTransDTO {

    private Long videoId;

    private Integer definitionType;

    private String format;

    private String appKey;

    private Long nonce;

    private String signature;

    public QukTransDTO() {
        super();
        this.nonce = System.currentTimeMillis();
        this.appKey = "y5vxpw9gdkegeenk";
        String content = "appKey=" + this.appKey + "&nonce=" + this.nonce;
        String appSecret = "71SYb04Cgx0Ap6FS";
        this.signature = Base64Util.encode(HmacSha1Util.hamcsha1(content.getBytes(), appSecret.getBytes()));
    }

    public static void main(String[] args) {
        QukTransDTO param = new QukTransDTO();
        param.setVideoId(1532675320628748L);
        param.setDefinitionType(2);
        param.setFormat("mp4");
        JSONObject json = JSONObject.fromObject(param);
        String requestJson = json.toString();
        System.out.println(requestJson);
    }
}
