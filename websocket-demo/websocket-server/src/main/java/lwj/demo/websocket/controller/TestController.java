package lwj.demo.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import lwj.demo.websocket.entity.ApiResult;
import lwj.demo.websocket.entity.VerifiedBarrageVO;
import lwj.demo.websocket.server.WebSocketServer;
import lwj.demo.websocket.util.JsonMapper;

@Slf4j
@RestController
@Api(value = "websocket", description = "websocket")
public class TestController {

    @Autowired
    private WebSocketServer webSocketServer;

    @ApiOperation(value = "群发", notes = "群发")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "", response = ApiResult.class) })
    @RequestMapping(path = "/websocket/send", method = RequestMethod.POST)
    public ApiResult sendBarrage(@RequestBody VerifiedBarrageVO msg) {
        try {
            webSocketServer.sendInfo(JsonMapper.toJsonString(msg));
            return ApiResult.success();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ApiResult.failure();
        }
    }
}
