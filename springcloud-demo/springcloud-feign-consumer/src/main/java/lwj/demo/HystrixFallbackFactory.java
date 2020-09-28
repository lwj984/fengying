package lwj.demo;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class HystrixFallbackFactory implements FallbackFactory<TestService> {

    @Override
    public TestService create(Throwable throwable) {
        return () -> "Feign + hystrix ,提供者服务挂了";
    }

}