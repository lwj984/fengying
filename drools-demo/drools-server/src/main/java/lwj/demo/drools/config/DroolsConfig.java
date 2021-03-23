package lwj.demo.drools.config;

import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.internal.utils.KieHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lwj.demo.drools.rules.NewKieBase;

@Configuration
public class DroolsConfig {

    @Bean("kieBase")
    public KieBase kieBase() {
        KieHelper helper = new KieHelper();
        helper.addContent(NewKieBase.activityRule(), ResourceType.DRL);
        return helper.build();
    }

}
