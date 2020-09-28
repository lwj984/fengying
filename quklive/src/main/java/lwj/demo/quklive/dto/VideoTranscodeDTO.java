package lwj.demo.quklive.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class VideoTranscodeDTO {

    @ApiModelProperty("视频ID")
    private Long id;

    @ApiModelProperty("所有转码后的视频链接列表")
    private List<UrlInfoDTO> urlList;

    @ApiModelProperty("13位时间戳，事件触发时间")
    private Long operateTime;

}
