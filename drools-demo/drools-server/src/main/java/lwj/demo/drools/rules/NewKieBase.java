package lwj.demo.drools.rules;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NewKieBase {

    // 将业务规则写到规则库中
    public static KieBase rulekieBase(String rule) {// rule值就是我们动态传入的规则内容
        KieHelper helper = new KieHelper();
        KieBase kieBase = null;
        try {
            helper.addContent(rule, ResourceType.DRL);
            kieBase = helper.build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return kieBase;
    }

    public static boolean compareTime(String targetTime, String compareTime, int operator) {
        boolean re = false;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date tt = sdf.parse(targetTime);
            Date ct = sdf.parse(compareTime);
            switch (operator) {
                case 1:
                    re = tt.before(ct);
                    break;
                case 2:
                    re = tt.after(ct);
                    break;
                case 3:
                    re = !tt.before(ct);
                    break;
                case 4:
                    re = !tt.after(ct);
                    break;
                case 5:
                    re = tt.equals(ct);
                    break;
                case 6:
                    re = !tt.equals(ct);
                    break;
                default:
            }
        } catch (ParseException e) {
        }
        return re;
    }

    public static boolean contain(String target, String compare, int operator) {
        boolean re = false;
        switch (operator) {
            case 7:
                re = target.contains(compare);
                break;
            case 8:
                re = !target.contains(compare);
                break;
            default:
        }
        return re;
    }

    public static String activityRule() {
        StringBuilder ruleDrl = new StringBuilder();
        ruleDrl.append("package rules \n");
        ruleDrl.append("import java.util.*; \n");
        ruleDrl.append("import java.text.*; \n");
        ruleDrl.append("rule \'rule_1\' \n");
        ruleDrl.append("    no-loop true \n");
        ruleDrl.append("    activation-group \"test\" \n");
        ruleDrl.append("    salience  10 \n");
        ruleDrl.append("    when \n");
        ruleDrl.append("        $map : Map($map[\"droolsType\"]==\"param\")\n");
        ruleDrl.append("        $re : Map($re[\"droolsType\"]==\"result\")\n");
        ruleDrl.append("        Map($map[\"status\"]==\"0\") \n");
        ruleDrl.append("    then \n");
        ruleDrl.append("        $re.put(\"resultInt\", 1); \n");
        ruleDrl.append("        $re.put(\"resultStr\", \"高级礼物\"); \n");
        ruleDrl.append("end \n");
        ruleDrl.append("rule    \'rule_2\' \n");
        ruleDrl.append("    no-loop true \n");
        ruleDrl.append("    activation-group \"test\" \n");
        ruleDrl.append("    salience  10 \n");
        ruleDrl.append("    when \n");
        ruleDrl.append("        $map : Map($map[\"droolsType\"]==\"param\", $map[\"status\"]==\"1\")\n");
        ruleDrl.append("        $re : Map($re[\"droolsType\"]==\"result\")\n");
        ruleDrl.append("        eval(compareTime((String)$map.get(\"time\"), \"2020-01-01 13:00:00\", 2))\n");
        ruleDrl.append("    then \n");
        ruleDrl.append("        $re.put(\"resultInt\", 2); \n");
        ruleDrl.append("        $re.put(\"resultStr\", \"无礼物\"); \n");
        ruleDrl.append("end \n");
        ruleDrl.append("\n");
        ruleDrl.append("function boolean compareTime(String targetTime, String compareTime, int operator) {\n");
        ruleDrl.append("    boolean re = false;\n");
        ruleDrl.append("    SimpleDateFormat sdf = new SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\");\n");
        ruleDrl.append("    try {\n");
        ruleDrl.append("        if (targetTime != null && compareTime != null && operator > 0) {\n");
        ruleDrl.append("            Date tt = sdf.parse(targetTime);\n");
        ruleDrl.append("            Date ct = sdf.parse(compareTime);\n");
        ruleDrl.append("            switch (operator) {\n");
        ruleDrl.append("                case 1:\n");
        ruleDrl.append("                    re = tt.before(ct);\n");
        ruleDrl.append("                    break;\n");
        ruleDrl.append("                case 2:\n");
        ruleDrl.append("                    re = tt.after(ct);\n");
        ruleDrl.append("                    break;\n");
        ruleDrl.append("                case 3:\n");
        ruleDrl.append("                    re = !tt.before(ct);\n");
        ruleDrl.append("                    break;\n");
        ruleDrl.append("                case 4:\n");
        ruleDrl.append("                    re = !tt.after(ct);\n");
        ruleDrl.append("                    break;\n");
        ruleDrl.append("                case 5:\n");
        ruleDrl.append("                    re = tt.equals(ct);\n");
        ruleDrl.append("                    break;\n");
        ruleDrl.append("                case 6:\n");
        ruleDrl.append("                    re = !tt.equals(ct);\n");
        ruleDrl.append("                    break;\n");
        ruleDrl.append("                default:\n");
        ruleDrl.append("            }\n");
        ruleDrl.append("        }\n");
        ruleDrl.append("    } catch (ParseException e) {\n");
        ruleDrl.append("    }\n");
        ruleDrl.append("    return re;\n");
        ruleDrl.append("}\n");
        ruleDrl.append("\n");
        ruleDrl.append("function boolean contain(String target, String compare, int operator) {\n");
        ruleDrl.append("    boolean re = false;\n");
        ruleDrl.append("    switch (operator) {\n");
        ruleDrl.append("        case 7:\n");
        ruleDrl.append("            re = target.contains(compare);\n");
        ruleDrl.append("            break;\n");
        ruleDrl.append("        case 8:\n");
        ruleDrl.append("            re = !target.contains(compare);\n");
        ruleDrl.append("            break;\n");
        ruleDrl.append("        default:\n");
        ruleDrl.append("    }\n");
        ruleDrl.append("    return re;\n");
        ruleDrl.append("}\n");
        return ruleDrl.toString();
    }

    public static void main(String[] args) {
        KieBase kieBase = NewKieBase.rulekieBase(activityRule());
        if (kieBase != null) {
            List<Map<String, Object>> list = new ArrayList<>();
            for (int i = 1; i <= 1; i++) {
                Map<String, Object> m1 = new HashMap<>();
                m1.put("factId", i + "");
                m1.put("status", "1");
                m1.put("message", "111");
                m1.put("droolsType", "param");
                list.add(m1);
                Map<String, Object> m2 = new HashMap<>();
                m2.put("factId", i * 2 + "");
                m2.put("status", "0");
                m2.put("message", "222");
                m2.put("droolsType", "param");
                list.add(m2);
            }

            long start = System.currentTimeMillis();
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
            log.info("耗时 {}ms", (System.currentTimeMillis() - start));
            log.info("匹配 {}次", c);
            for (Map<String, Object> r : resultList) {
                log.info("{}", r);
            }
        }
    }
}
