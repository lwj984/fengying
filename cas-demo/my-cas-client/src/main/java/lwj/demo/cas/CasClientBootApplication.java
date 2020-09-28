package lwj.demo.cas;

import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

import net.unicon.cas.client.configuration.CasClientConfigurerAdapter;
import net.unicon.cas.client.configuration.EnableCasClient;

@SpringBootApplication
@EnableCasClient
public class CasClientBootApplication extends CasClientConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(CasClientBootApplication.class, args);
    }

    @Bean
    public ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> singleSignOutHttpSessionListener() {
        ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> registration = new ServletListenerRegistrationBean<SingleSignOutHttpSessionListener>(
                new SingleSignOutHttpSessionListener());
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean singleSignOutFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new SingleSignOutFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("casServerUrlPrefix", "http://192.168.89.69:8090");
        registration.setName("Single Sign Out Filter");
        registration.setOrder(2);
        return registration;
    }

    @Override
    public void configureAuthenticationFilter(FilterRegistrationBean authenticationFilter) {
        authenticationFilter.setOrder(3);
    }

    @Override
    public void configureValidationFilter(FilterRegistrationBean validationFilter) {
        validationFilter.setOrder(4);
    }

    @Override
    public void configureHttpServletRequestWrapperFilter(FilterRegistrationBean httpServletRequestWrapperFilter) {
        httpServletRequestWrapperFilter.setOrder(5);
    }

    @Override
    public void configureAssertionThreadLocalFilter(FilterRegistrationBean assertionThreadLocalFilter) {
        assertionThreadLocalFilter.setOrder(6);
    }

}
