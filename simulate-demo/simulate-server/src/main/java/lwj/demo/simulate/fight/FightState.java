package lwj.demo.simulate.fight;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lwj.demo.simulate.enums.FunctionalBuffEnum;
import lwj.demo.simulate.enums.FunctionalDeBuffEnum;

/**
 * 战斗时数据,有初始值
 * @author liuweijia
 * @date 2020年10月9日 下午4:18:44 
 * @since 1.0.0
 */
@Data
public class FightState {

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

    /**
     * 功能性增益
     */
    private List<FunctionalBuffEnum> functionalBuffs = new ArrayList<>();

    /**
     * 功能性减益
     */
    private List<FunctionalDeBuffEnum> functionalDeBuffs = new ArrayList<>();

}
