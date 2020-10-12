package lwj.demo.simulate;

import com.alibaba.fastjson.JSON;

import lwj.demo.simulate.dto.FightResult;
import lwj.demo.simulate.engine.FightEngine;
import lwj.demo.simulate.enums.ArmsEnum;
import lwj.demo.simulate.fight.Battlefield;
import lwj.demo.simulate.fight.Lineup;
import lwj.demo.simulate.general.General;
import lwj.demo.simulate.general.GeneralEnum;

public class Test {

    public static void main(String[] args) {
        FightEngine engine = new FightEngine();
        FightResult result = engine.fightStart(new Battlefield(
                new Lineup(new General(GeneralEnum.SIMAYI, 10000, 20000, 30000, 15000, 4, null, null), null, null,
                        ArmsEnum.MAULER),
                new Lineup(new General(GeneralEnum.GUOHUAI, 10000, 20000, 30000, 15000, 4, null, null), null, null,
                        ArmsEnum.MAULER)));
        System.out.println(JSON.toJSONString(result));
    }

}
