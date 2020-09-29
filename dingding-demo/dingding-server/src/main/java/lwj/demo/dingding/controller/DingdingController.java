package lwj.demo.dingding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taobao.api.ApiException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lwj.demo.dingding.entity.ApiResult;
import lwj.demo.dingding.service.DingdingService;

@Api(tags = "dingding")
@RequestMapping("/ding/")
@RestController
public class DingdingController {

    @Autowired
    private DingdingService dingdingService;

    @ApiOperation(value = "获取token", notes = "获取token")
    @PostMapping("/access-token-get")
    public ApiResult accessTokenGet() throws ApiException {
        return ApiResult.success(dingdingService.accessTokenGet());
    }

    @ApiOperation(value = "创建审批实例", notes = "创建审批实例")
    @PostMapping("/processinstance-create")
    public ApiResult processinstanceCreate(@RequestParam String accessToken) throws ApiException {
        return ApiResult.success(dingdingService.processinstanceCreate(accessToken));
    }

    @ApiOperation(value = "注册回调", notes = "注册回调")
    @PostMapping("/callBack-register")
    public ApiResult callBackRegister(@RequestParam String accessToken) throws ApiException {
        return ApiResult.success(dingdingService.callBackRegister(accessToken));
    }

    @ApiOperation(value = "获取注册回调", notes = "获取注册回调")
    @PostMapping("/callBack-get")
    public ApiResult callBackGet(@RequestParam String accessToken) throws ApiException {
        return ApiResult.success(dingdingService.callBackGet(accessToken));
    }

}
