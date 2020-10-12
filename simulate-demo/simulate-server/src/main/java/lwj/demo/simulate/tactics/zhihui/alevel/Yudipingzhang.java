package lwj.demo.simulate.tactics.zhihui.alevel;

import lombok.Data;
import lwj.demo.simulate.enums.ExecutorEnum;
import lwj.demo.simulate.enums.TacticsTypeEnum;
import lwj.demo.simulate.fight.Battlefield;
import lwj.demo.simulate.tactics.Tactics;

/**
 * 御敌屏障
 *
 * @author liuweijia
 * @date 2020年10月9日 上午11:26:09 
 * @since 1.0.0
 */
@Data
public class Yudipingzhang implements Tactics {

    private String name = "御敌屏障";

    private TacticsTypeEnum tacticsType = TacticsTypeEnum.ZHIHUI;

    @Override
    public void prepare(ExecutorEnum executor, Battlefield battlefield) {
        // TODO Auto-generated method stub

    }

}
