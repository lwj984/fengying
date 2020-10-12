package lwj.demo.simulate.engine;

import org.springframework.stereotype.Component;

import lwj.demo.simulate.dto.FightResult;
import lwj.demo.simulate.fight.Battlefield;

@Component
public class FightEngine {

    /**
     * 战斗
     * @param battlefield
     * @return
     */
    public FightResult fightStart(Battlefield battlefield) {
        // 战报
        StringBuilder warReport = new StringBuilder("");
        // 准备阶段
        this.preparation(battlefield, warReport);
        int round = 0;
        int result = 0;
        // 最多8回合
        while (round < 8 && result == 0) {
            round++;
            result = this.fight(battlefield, warReport, round);
        }
        return new FightResult(result, warReport.toString(), battlefield, round);
    }

    /**
     * 准备阶段
     * @param battlefield
     */
    private void preparation(Battlefield battlefield, StringBuilder warReport) {
        warReport = warReport.append("【准备阶段】\n");

    }

    /**
     * 战斗回合
     * @param battlefield
     * @param round
     */
    private int fight(Battlefield battlefield, StringBuilder warReport, int round) {
        return 0;
    }

}
