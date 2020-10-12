package lwj.demo.simulate.general;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lwj.demo.simulate.enums.NationalityEnum;
import lwj.demo.simulate.enums.TagEnum;
import lwj.demo.simulate.tactics.Tactics;
import lwj.demo.simulate.tactics.zhihui.alevel.Yudipingzhang;
import lwj.demo.simulate.tactics.zhihui.slevel.Yingshilanggu;

/**
 * 武将枚举
 * @author liuweijia
 * @date 2020年10月12日 下午3:11:08 
 * @since 1.0.0
 */
@Getter
public enum GeneralEnum {

    /****************  魏 5  ******************/
    SIMAYI("司马懿", NationalityEnum.WEI, Arrays.asList(new TagEnum[] { TagEnum.MOU, TagEnum.FU }), 2, 1, 2, 1, 2, new Yingshilanggu()),

    /****************  魏 4  ******************/
    GUOHUAI("郭淮", NationalityEnum.WEI, Arrays.asList(new TagEnum[] { TagEnum.FU, TagEnum.DUN }), 4, 1, 3, 2, 3, new Yudipingzhang());

    /**
     * 姓名
     */
    private String name;
    /**
     * 国籍
     */
    private NationalityEnum nationality;
    /**
     * 标签
     */
    private List<TagEnum> tags;
    /**
     * 骑兵适性（1S,2A,3B,4C,5D）
     */
    private int cavalry;
    /**
     * 盾兵适性（1S,2A,3B,4C,5D）
     */
    private int mauler;
    /**
     * 弓兵适性（1S,2A,3B,4C,5D）
     */
    private int bowman;
    /**
     * 枪兵适性（1S,2A,3B,4C,5D）
     */
    private int spearman;
    /**
     * 机械适性（1S,2A,3B,4C,5D）
     */
    private int machine;
    /**
     * 自带战法
     */
    private Tactics firstTactics;

    private GeneralEnum(String name, NationalityEnum nationality, List<TagEnum> tags, int cavalry, int mauler,
            int bowman, int spearman, int machine, Tactics firstTactics) {
        this.name = name;
        this.nationality = nationality;
        this.tags = tags;
        this.cavalry = cavalry;
        this.mauler = mauler;
        this.bowman = bowman;
        this.spearman = spearman;
        this.machine = machine;
        this.firstTactics = firstTactics;
    }

}
