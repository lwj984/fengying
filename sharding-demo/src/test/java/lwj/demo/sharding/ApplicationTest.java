package lwj.demo.sharding;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lwj.demo.sharding.entity.Order;
import lwj.demo.sharding.service.OrderService;

/**
 * 测试类
 *
 * @author liuweijia
 * @date 2017年11月10日 下午5:06:20 
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void add() throws InterruptedException {
        int re = 0;
        for (int i = 0; i < 100; i++) {
            re += orderService.add(1L);
        }
        Assert.assertEquals(100, re);
    }

    // @Test
    public void get() {
        List<Order> re = orderService.getById(1L);
        System.out.println(re);
        Assert.assertNotNull(re);
    }
}
