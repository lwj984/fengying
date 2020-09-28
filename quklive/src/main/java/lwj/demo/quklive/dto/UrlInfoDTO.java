package lwj.demo.quklive.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class UrlInfoDTO {

    @ApiModelProperty("分辨率类型， 1：高清 2：标清 3：低清")
    private Integer type;

    @ApiModelProperty("访问地址")
    private String url;
}
