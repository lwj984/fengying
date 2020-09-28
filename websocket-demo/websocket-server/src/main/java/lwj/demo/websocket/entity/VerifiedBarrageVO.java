package lwj.demo.websocket.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 审核弹幕
 *
 * @author liuweijia
 * @date 2018年3月2日 上午10:56:29 
 * @since 1.0.0
 */
@Data
@ApiModel
public class VerifiedBarrageVO implements Serializable {

    private static final long serialVersionUID = 8190475118234701261L;

    @ApiModelProperty("弹幕id")
    private Long barrageId;

    @ApiModelProperty("用户昵称")
    private String nickname;

    @ApiModelProperty("用户头像")
    private String headPic;

    @ApiModelProperty("弹幕内容")
    private String barrageContent;

    @ApiModelProperty("弹幕类型 1广告 2普通")
    private Integer barrageType;

    public VerifiedBarrageVO(Long barrageId, String nickname, String headPic, String barrageContent,
            Integer barrageType) {
        super();
        this.barrageId = barrageId;
        this.nickname = nickname;
        this.headPic = headPic;
        this.barrageContent = barrageContent;
        this.barrageType = barrageType;
    }

    public VerifiedBarrageVO() {
        super();
    }
}
