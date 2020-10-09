package lwj.demo.simulate.general;

import lombok.Data;
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

    /** 战斗时数据,有初始值  **/
    /**
     * 存活数
     */
    private int alive = 10000;
    /**
     * 死亡
     */
    private int death = 0;
    /**
     * 伤兵
     */
    private int wound = 0;

    public General(int force, int intellect, int command, int speed, int star, Tactics secondTactics,
            Tactics thirdTactics) {
        super();
        this.force = force;
        this.intellect = intellect;
        this.command = command;
        this.speed = speed;
        this.star = star;
        this.secondTactics = secondTactics;
        this.thirdTactics = thirdTactics;
    }

}
