package lwj.demo.drools.entity;

import lombok.Data;

@Data
public class User {

    private String name; // 姓名

    private Integer age; // 年龄

    private Integer gender; // 性别 1女 2男

    private Integer married; // 是否已婚 1未婚 2已婚

    private Integer jewelryWorks; // 珠宝展有效 0无1有

    private Integer arrivedNoOrder; // 累计有过3次到展礼领取记录且最近一次到场无订单 0否1是

    private Integer yingMix; // 去掉和母婴第1届到现在盘子有交集的会员 0无1有

    private Integer result;// 结果0无礼

    private Integer condition1;
    
    private Integer condition2;
    
    private Integer condition3;
    
    private Integer condition4;
    
    private Integer condition5;
}
