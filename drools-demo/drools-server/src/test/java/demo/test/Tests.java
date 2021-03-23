package demo.test;
import java.math.BigDecimal;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import lwj.demo.drools.entity.Borrower;

public class Tests {

    @Test
    public void testBorrower01() {
        // 初始化kie容器
        KieServices kieServices = KieServices.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();

        // 创建名为testBorrower01-rules的kie会话（其配置在kmodule.xml文件中）
        KieSession kieSession = kieContainer.newKieSession("testBorrower01-rules");

        // 指定需要匹配的一组规则（testBorrower01），对应drl文件中的agenda-group属性
        // kieSession.getAgenda().getAgendaGroup("testBorrower01").setFocus();

        // 创建两个借贷人信息，月收入分别为8千和2万
        Borrower borrower1 = new Borrower();
        borrower1.setName("张三");
        borrower1.setIncome(new BigDecimal(8000.00));
        Borrower borrower2 = new Borrower();
        borrower2.setName("李四");
        borrower2.setIncome(new BigDecimal(30000.00));

        // 将借贷人信息传入kie会话中
        kieSession.insert(borrower1);
        kieSession.insert(borrower2);

        // 调用kie会话API与drools交互，执行规则
        int count = kieSession.fireAllRules();
        // 关闭会话
        kieSession.dispose();

        // 输出结果
        System.out.println("Fire " + count + " rule(s)!");
        System.out.println(borrower1.getName() + "可授信额度[" + borrower1.getCreditLine() + "]元");
        System.out.println(borrower2.getName() + "可授信额度[" + borrower2.getCreditLine() + "]元");
    }
}
