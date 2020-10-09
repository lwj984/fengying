package lwj.demo.simulate.engine;

import org.springframework.stereotype.Component;

import lwj.demo.simulate.fight.Battlefield;

@Component
public class FightEngine {

    /**
     * 战斗
     * @param battlefield
     * @return
     */
    public String fightStart(Battlefield battlefield) {
        // 准备阶段
        int round = 0;
        return "";
    }

}
