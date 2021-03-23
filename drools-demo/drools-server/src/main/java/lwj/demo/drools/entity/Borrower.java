package lwj.demo.drools.entity;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Borrower {

    private String name; // 姓名
    private int age; // 年龄
    private BigDecimal income; // 月收入
    private BigDecimal creditLine; // 可授信额度
}
