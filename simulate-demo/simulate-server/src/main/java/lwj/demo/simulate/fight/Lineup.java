package lwj.demo.simulate.fight;

import lombok.Data;
import lwj.demo.simulate.enums.ArmsEnum;
import lwj.demo.simulate.general.General;
import lwj.demo.simulate.tactics.Tactics;

/**
 * 阵容
 * @author liuweijia
 * @date 2020年10月9日 下午1:57:08 
 * @since 1.0.0
 */
@Data
public class Lineup {

    /**
     * 主将
     */
    private General mainGeneral;

    /**
     * 第一副将
     */
    private General viceGeneralFirst;

    /**
     * 第二副将
     */
    private General viceGeneralSecond;

    /**
     * 兵种
     */
    private ArmsEnum arms;

    /**
     * 缘分，也是一种战法
     */
    private Tactics yuanfen;

    public Lineup() {
        super();
    }

    public Lineup(General mainGeneral, General viceGeneralFirst, General viceGeneralSecond, ArmsEnum arms) {
        super();
        this.mainGeneral = mainGeneral;
        this.viceGeneralFirst = viceGeneralFirst;
        this.viceGeneralSecond = viceGeneralSecond;
        this.arms = arms;
    }
}
