package lwj.demo.simulate.dto;

import lombok.Data;
import lwj.demo.simulate.fight.Battlefield;

@Data
public class FightResult {

    /**
     * 结果，0平，1胜利，2失败
     */
    private int result;

    /**
     * 战报
     */
    private String warReport;

    /**
     * 战场数据
     */
    private Battlefield battlefield;

    /**
     * 回合数
     */
    private int round;

    public FightResult() {
        super();
    }

    public FightResult(int result, String warReport, Battlefield battlefield, int round) {
        super();
        this.result = result;
        this.warReport = warReport;
        this.battlefield = battlefield;
        this.round = round;
    }

}
