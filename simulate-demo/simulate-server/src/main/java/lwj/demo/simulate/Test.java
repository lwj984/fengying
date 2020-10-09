package lwj.demo.simulate;

import lombok.extern.slf4j.Slf4j;
import lwj.demo.simulate.enums.ArmsEnum;
import lwj.demo.simulate.fight.Lineup;
import lwj.demo.simulate.general.wei.orange.Simayi;

@Slf4j
public class Test {

    public static void main(String[] args) {
        Lineup lineup = new Lineup(new Simayi(10000, 20000, 30000, 15000, 4, null, null), null, null, ArmsEnum.MAULER);
        log.info("{}", lineup);
    }

}
