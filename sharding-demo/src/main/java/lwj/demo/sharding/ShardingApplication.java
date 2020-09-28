package lwj.demo.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "lwj.demo.*")
@MapperScan("lwj.demo.sharding.mapper")
public class ShardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingApplication.class, args);
    }
}
