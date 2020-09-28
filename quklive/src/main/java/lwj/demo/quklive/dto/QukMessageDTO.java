package lwj.demo.quklive.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class QukMessageDTO {

    @ApiModelProperty("触发事件名")
    private String event;

    @ApiModelProperty("事件关联数据，注意：字段类型为字符串，字段内容为json格式")
    private String data;

    @ApiModelProperty("为了鉴权， 用户在趣看平台的appKey")
    private String appKey;

    @ApiModelProperty("为了鉴权，当前时间戳")
    private Long nonce;

    @ApiModelProperty("为了鉴权，签名")
    private String signature;

}
