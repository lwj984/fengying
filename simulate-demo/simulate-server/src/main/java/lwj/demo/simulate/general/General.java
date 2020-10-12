package lwj.demo.simulate.general;

import java.util.List;

import lombok.Data;
import lwj.demo.simulate.enums.NationalityEnum;
import lwj.demo.simulate.enums.TagEnum;
import lwj.demo.simulate.tactics.Tactics;

/**
 * 武将
 * 这里的数值是面板上的数据，并非战斗时的数值
 * @author liuweijia
 * @date 2020年10月9日 下午1:48:04 
 * @since 1.0.0
 */
@Data
public class General {

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

    /**
     * 武力（界面值*100）
     */
    private int force;
    /**
     * 智力（界面值*100）
     */
    private int intellect;
    /**
     * 统率（界面值*100）
     */
    private int command;
    /**
     * 速度（界面值*100）
     */
    private int speed;
    /**
     * 星級
     */
    private int star;
    /**
     * 二战法
     */
    private Tactics secondTactics;
    /**
     * 三战法
     */
    private Tactics thirdTactics;

    public General(GeneralEnum generalEnum, int force, int intellect, int command, int speed, int star,
            Tactics secondTactics, Tactics thirdTactics) {
        super();
        this.name = generalEnum.getName();
        this.nationality = generalEnum.getNationality();
        this.tags = generalEnum.getTags();
        this.cavalry = generalEnum.getCavalry();
        this.mauler = generalEnum.getMauler();
        this.bowman = generalEnum.getBowman();
        this.spearman = generalEnum.getSpearman();
        this.machine = generalEnum.getMachine();
        this.firstTactics = generalEnum.getFirstTactics();
        this.force = force;
        this.intellect = intellect;
        this.command = command;
        this.speed = speed;
        this.star = star;
        this.secondTactics = secondTactics;
        this.thirdTactics = thirdTactics;
    }

}
