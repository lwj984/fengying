package lwj.demo.quklive.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class VideoAnalyseDTO {

    @ApiModelProperty("视频ID")
    private Long id;

    @ApiModelProperty("视频宽")
    private Integer width;

    @ApiModelProperty("视频高")
    private Integer height;

    @ApiModelProperty("视频源访问地址")
    private String sourceUrl;

    @ApiModelProperty("视频源是否可直接观看，1：可以，0：不可")
    private Integer sourceCanPlay;

    @ApiModelProperty("视频截图")
    private String screenshot;

    @ApiModelProperty("视频时长，单位毫秒")
    private Integer during;

    @ApiModelProperty("13位时间戳，事件触发时间")
    private Long operateTime;

}
