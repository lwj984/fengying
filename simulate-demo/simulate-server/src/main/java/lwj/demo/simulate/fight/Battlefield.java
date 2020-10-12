package lwj.demo.simulate.fight;

import lombok.Data;

/**
 * 战场
 * @author liuweijia
 * @date 2020年10月9日 下午2:51:41 
 * @since 1.0.0
 */
@Data
public class Battlefield {

    /**
     * 蓝方
     */
    private Lineup blue;

    /**
     * 红方
     */
    private Lineup red;

    /**
     * 蓝方主将战斗状态
     */
    private FightState blueMainState = new FightState();

    /**
     * 蓝方一副战斗状态
     */
    private FightState blueViceFirstState = new FightState();

    /**
     * 蓝方二副战斗状态
     */
    private FightState blueViceSecondState = new FightState();

    /**
     * 红方主将战斗状态
     */
    private FightState redMainState = new FightState();

    /**
     * 红方一副战斗状态
     */
    private FightState redViceFirstState = new FightState();

    /**
     * 红方二副战斗状态
     */
    private FightState redViceSecondState = new FightState();

    public Battlefield() {
        super();
    }

    public Battlefield(Lineup blue, Lineup red) {
        super();
        this.blue = blue;
        this.red = red;
    }
}
