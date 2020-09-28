package lwj.demo.quklive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * quklive
 *
 * @author liuweijia
 * @date 2018年7月26日 下午5:39:02 
 * @since 1.0.0
 */
@SpringBootApplication
public class QukliveApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(QukliveApplication.class);
        application.run(args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
