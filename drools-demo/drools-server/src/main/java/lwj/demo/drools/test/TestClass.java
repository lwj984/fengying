//package lwj.demo.drools.test;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.jmeter.config.Arguments;
//import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
//import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
//import org.apache.jmeter.samplers.SampleResult;
//import org.kie.api.KieBase;
//import org.kie.api.runtime.KieSession;
//
//import com.alibaba.fastjson.JSON;
//
//import lwj.demo.drools.rules.NewKieBase;
//
//public class TestClass extends AbstractJavaSamplerClient {
//
//    @Override
//    public Arguments getDefaultParameters() {
//        Arguments args = new Arguments();
//        return args;
//    }
//
//    @Override
//    public SampleResult runTest(JavaSamplerContext context) {
//        // 创建SampleResult对象，用于记录执行结果的状态，并返回
//        SampleResult sampleResult = new SampleResult();
//
//        // 获取JMeter中输入的用户参数
//        // String mobile = context.getParameter("mobile");
//
//        // 开始
//        sampleResult.sampleStart();
//
//        List<Map<String, Object>> resultList = new ArrayList<>();
//        KieBase kieBase = NewKieBase.rulekieBase(NewKieBase.activityRule());
//        if (kieBase != null) {
//            List<Map<String, Object>> list = new ArrayList<>();
//            Map<String, Object> m1 = new HashMap<>();
//            m1.put("factId", "111");
//            m1.put("status", "1");
//            m1.put("message", "111");
//            m1.put("droolsType", "param");
//            list.add(m1);
//
//            int c = 0;
//            KieSession kieSession = null;
//            Map<String, Object> result = null;
//            for (Map<String, Object> map : list) {
//                kieSession = kieBase.newKieSession();
//                result = new HashMap<>();
//                result.put("factId", map.get("factId"));
//                result.put("droolsType", "result");
//                kieSession.insert(map);
//                kieSession.insert(result);
//                resultList.add(result);
//                c += kieSession.fireAllRules();
//                kieSession.dispose();
//            }
//        }
//
//        // 结束
//        sampleResult.sampleEnd();
//
//        sampleResult.setSuccessful(true);
//        sampleResult.setResponseCode("200");
//        sampleResult.setResponseData(JSON.toJSONString(resultList), null);
//
//        // 返回
//        return sampleResult;
//    }
//    
//    public static void main(String[] args) {
//        Arguments params = new Arguments();
//
//        JavaSamplerContext context = new JavaSamplerContext(params);
//        TestClass test = new TestClass();
//        SampleResult result = test.runTest(context);
//        System.err.println(result.getResponseDataAsString());
//    }
//}
