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

}
