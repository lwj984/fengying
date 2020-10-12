package lwj.demo.simulate.tactics;

import lwj.demo.simulate.enums.ExecutorEnum;
import lwj.demo.simulate.fight.Battlefield;

/**
 * 战法
 * @author liuweijia
 * @date 2020年10月12日 下午4:54:46 
 * @since 1.0.0
 */
public interface Tactics {

    /**
     * 准备阶段
     * @param executor
     * @param battlefield
     */
    public void prepare(ExecutorEnum executor, Battlefield battlefield);

}
