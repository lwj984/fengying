package lwj.demo.drools.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/drools/")
public class TestController {

    @Autowired
    private KieBase kieBase;

    @ApiOperation(value = "发送短信", notes = "发送短信")
    @PostMapping("/test")
    public List<Map<String, Object>> test() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> m1 = new HashMap<>();
        m1.put("factId", "111");
        m1.put("status", "1");
        m1.put("message", "111");
        m1.put("droolsType", "param");
        list.add(m1);

        int c = 0;
        List<Map<String, Object>> resultList = new ArrayList<>();
        KieSession kieSession = null;
        Map<String, Object> result = null;
        for (Map<String, Object> map : list) {
            kieSession = kieBase.newKieSession();
            result = new HashMap<>();
            result.put("factId", map.get("factId"));
            result.put("droolsType", "result");
            kieSession.insert(map);
            kieSession.insert(result);
            resultList.add(result);
            c += kieSession.fireAllRules();
            kieSession.dispose();
        }
        return resultList;
    }

}
