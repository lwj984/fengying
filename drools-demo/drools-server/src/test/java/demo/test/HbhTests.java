package demo.test;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import lwj.demo.drools.entity.User;

public class HbhTests {

    @Test
    public void testBorrower01() {
        // 初始化kie容器
        KieServices kieServices = KieServices.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();

        // 创建名为testBorrower01-rules的kie会话（其配置在kmodule.xml文件中）
        KieSession kieSession = kieContainer.newKieSession("hbh-rules");

        User user1 = new User();
        user1.setName("张三");
        user1.setAge(18);
        user1.setGender(1);
        user1.setMarried(1);
        user1.setArrivedNoOrder(1);
        user1.setJewelryWorks(1);
        user1.setYingMix(1);
        user1.setCondition1(1);
        user1.setCondition2(1);
        user1.setCondition3(1);
        user1.setCondition4(1);
        user1.setCondition5(1);

        User user2 = new User();
        user2.setName("李四");
        user2.setAge(25);
        user2.setGender(1);
        user2.setMarried(1);
        user2.setArrivedNoOrder(0);
        user2.setJewelryWorks(0);
        user2.setYingMix(0);
        user2.setCondition1(1);
        user2.setCondition2(1);
        user2.setCondition3(1);
        user2.setCondition4(1);
        user2.setCondition5(1);

        // 调用kie会话API与drools交互，执行规则
        kieSession.insert(user2);
        int count = kieSession.fireAllRules();

        kieSession.insert(user1);
        count += kieSession.fireAllRules();
        // 关闭会话
        kieSession.dispose();

        // 输出结果
        System.out.println("Fire " + count + " rule(s)!");
        System.out.println(user1.getName() + " 结果 [" + user1.getResult() + "]");
        System.out.println(user2.getName() + " 结果 [" + user2.getResult() + "]");
    }
}
