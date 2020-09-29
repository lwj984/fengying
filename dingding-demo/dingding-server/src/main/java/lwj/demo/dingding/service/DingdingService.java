package lwj.demo.dingding.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiCallBackGetCallBackRequest;
import com.dingtalk.api.request.OapiCallBackRegisterCallBackRequest;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.dingtalk.api.request.OapiUserGetByMobileRequest;
import com.dingtalk.api.response.OapiCallBackGetCallBackResponse;
import com.dingtalk.api.response.OapiCallBackRegisterCallBackResponse;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiProcessinstanceCreateResponse;
import com.dingtalk.api.response.OapiUserGetByMobileResponse;
import com.taobao.api.ApiException;

@Service
public class DingdingService {

    private String appkey = "ding8cysltgd0nfp39lc";

    private String appsecret = "Lmiu3KczT91gUduKdN3cJcsAYbD1zMa_fe_Gw1ioaa41KR7Q2tenMEtYVxOemTMl";

    // private String accessToken = "1c844484532131f5937c48fd8360c21d";

    public String accessTokenGet() throws ApiException {
        DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey(appkey);
        request.setAppsecret(appsecret);
        request.setHttpMethod("GET");
        OapiGettokenResponse response = client.execute(request);
        return response.getAccessToken();
    }

    public String processinstanceCreate(String accessToken) throws ApiException {
        DingTalkClient dingTalkClient = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/get_by_mobile");
        OapiUserGetByMobileRequest userRequest = new OapiUserGetByMobileRequest();
        userRequest.setMobile("15157181386");
        OapiUserGetByMobileResponse execute = dingTalkClient.execute(userRequest, accessToken);
        String userid1 = execute.getUserid();

        userRequest = new OapiUserGetByMobileRequest();
        userRequest.setMobile("15958124682");
        execute = dingTalkClient.execute(userRequest, accessToken);
        String userid2 = execute.getUserid();

        userRequest = new OapiUserGetByMobileRequest();
        userRequest.setMobile("15700094097");
        execute = dingTalkClient.execute(userRequest, accessToken);
        String userid3 = execute.getUserid();

        userRequest = new OapiUserGetByMobileRequest();
        userRequest.setMobile("15757831879");
        execute = dingTalkClient.execute(userRequest, accessToken);
        String userid4 = execute.getUserid();

        DefaultDingTalkClient client = new DefaultDingTalkClient(
                "https://oapi.dingtalk.com/topapi/processinstance/create");
        OapiProcessinstanceCreateRequest createRequest = new OapiProcessinstanceCreateRequest();
        createRequest.setAgentId(887157484L);
        createRequest.setProcessCode("PROC-BY6LI83V-4R8T1CHNUX58O0Z6C55M3-DTQJJGEJ-1");
        // 审批流表单控件，设置各表单项值
        List<OapiProcessinstanceCreateRequest.FormComponentValueVo> formComponentValues = new ArrayList<>();

        // 单行输入框
        OapiProcessinstanceCreateRequest.FormComponentValueVo vo1 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo1.setName("单行输入框示例");
        vo1.setValue("单行输入框value");

        // 多行输入框
        OapiProcessinstanceCreateRequest.FormComponentValueVo vo2 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo2.setName("多行输入框示例");
        vo2.setValue("多行输入框value");

        // 图片
        OapiProcessinstanceCreateRequest.FormComponentValueVo vo3 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo3.setName("图片示例");
        vo3.setValue("[\"https://img.hbhcdn.com/test/128833772955426816_2000.jpg\"]");

        // 明细包含控件
        // 明细-单行输入框
        OapiProcessinstanceCreateRequest.FormComponentValueVo ItemName1 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        ItemName1.setName("明细-单行输入框示例");
        ItemName1.setValue("明细-单行输入框value");
        // 明细-多行输入框
        OapiProcessinstanceCreateRequest.FormComponentValueVo ItemName2 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        ItemName2.setName("明细-多行输入框示例");
        ItemName2.setValue("明细-多行输入框value");
        // 明细-照片
        OapiProcessinstanceCreateRequest.FormComponentValueVo ItemName3 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        ItemName3.setName("明细-图片示例");
        ItemName3.setValue("[\"https://img.hbhcdn.com/test/128833772955426816_2000.jpg\"]");

        // 明细
        OapiProcessinstanceCreateRequest.FormComponentValueVo vo4 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo4.setName("明细示例");
        vo4.setValue(JSON.toJSONString(Arrays.asList(Arrays.asList(ItemName1, ItemName2, ItemName3))));

        // 添加单行输入框、多行输入框、图片、明细、附件到表单
        formComponentValues.add(vo1);
        formComponentValues.add(vo2);
        formComponentValues.add(vo3);
        formComponentValues.add(vo4);

        createRequest.setFormComponentValues(formComponentValues);
        createRequest.setApprovers(userid2 + "," + userid3 + "," + userid4);
        createRequest.setOriginatorUserId(userid1);
        createRequest.setDeptId(-1L);
        createRequest.setCcList(userid2 + "," + userid3 + "," + userid4);
        createRequest.setCcPosition("START_FINISH");
        OapiProcessinstanceCreateResponse createResponse = client.execute(createRequest, accessToken);

        return createResponse.getProcessInstanceId();
    }

    public String callBackRegister(String accessToken) throws ApiException {
        DingTalkClient dingTalkClient = new DefaultDingTalkClient(
                "https://oapi.dingtalk.com/call_back/register_call_back");
        OapiCallBackRegisterCallBackRequest callBackRegisterRequest = new OapiCallBackRegisterCallBackRequest();
        callBackRegisterRequest.setUrl("http://wanlongfei007.imdo.co/dingCallback");
        callBackRegisterRequest.setAesKey("P5pMzfmdJaAiFp5qKMod1eA5NSHCDhfGaAxNI4su1sJ");
        callBackRegisterRequest.setToken("123456");
        callBackRegisterRequest.setCallBackTag(Arrays.asList("bpms_task_change", "bpms_instance_change"));
        OapiCallBackRegisterCallBackResponse callBackRegisterResponse = dingTalkClient.execute(callBackRegisterRequest,
                accessToken);
        return callBackRegisterResponse.getErrmsg();
    }

    public String callBackGet(String accessToken) throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/call_back/get_call_back");
        OapiCallBackGetCallBackRequest request = new OapiCallBackGetCallBackRequest();
        request.setHttpMethod("GET");
        OapiCallBackGetCallBackResponse response = client.execute(request, accessToken);
        return response.getBody();
    }

}
