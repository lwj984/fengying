package lwj.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "exceptionMethod")
    @GetMapping(value = "/hello")
    public String hello() {
        return restTemplate.getForEntity("http://eureka-provider/test", String.class).getBody();
    }

    public String exceptionMethod() {
        return "provider is down";
    }
}
