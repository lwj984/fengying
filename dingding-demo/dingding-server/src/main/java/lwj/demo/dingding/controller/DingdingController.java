package lwj.demo.dingding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @ApiOperation(value = "test", notes = "test")
    @PostMapping("/test")
    public ApiResult test() throws ApiException {
        return ApiResult.success(dingdingService.gettoken());
    }

}
