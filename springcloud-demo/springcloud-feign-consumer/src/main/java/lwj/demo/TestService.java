package lwj.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-provider", fallbackFactory = HystrixFallbackFactory.class)
public interface TestService {

    @GetMapping("/test")
    public String test();

}
