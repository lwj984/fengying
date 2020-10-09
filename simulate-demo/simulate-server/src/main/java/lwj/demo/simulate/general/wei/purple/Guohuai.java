package lwj.demo.simulate.general.wei.purple;

import lombok.Data;
import lwj.demo.simulate.enums.NationalityEnum;
import lwj.demo.simulate.enums.TagEnum;
import lwj.demo.simulate.general.General;
import lwj.demo.simulate.tactics.Tactics;

/**
 * 郭淮
 * @author liuweijia
 * @date 2020年10月9日 上午10:52:41 
 * @since 1.0.0
 */
@Data
public class Guohuai extends General {

    /****************  固定值 begin *****************/
    /**
     * 姓名
     */
    private String name = "郭淮";
    /**
     * 国籍
     */
    private NationalityEnum nationality = NationalityEnum.WEI;
    /**
     * 标签
     */
    private TagEnum[] tags = new TagEnum[] { TagEnum.FU, TagEnum.DUN };
    /**
     * 骑兵适性（1S,2A,3B,4C,5D）
     */
    private int cavalry = 4;
    /**
     * 盾兵适性（1S,2A,3B,4C,5D）
     */
    private int mauler = 1;
    /**
     * 弓兵适性（1S,2A,3B,4C,5D）
     */
    private int bowman = 3;
    /**
     * 枪兵适性（1S,2A,3B,4C,5D）
     */
    private int spearman = 2;
    /**
     * 机械适性（1S,2A,3B,4C,5D）
     */
    private int machine = 3;

    /****************  固定值 end *****************/

    public Guohuai(int force, int intellect, int command, int speed, int star, Tactics secondTactics,
            Tactics thirdTactics) {
        super(force, intellect, command, speed, star, secondTactics, thirdTactics);
    }

}
