package lwj.demo.drools.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.JSON;

public class TreeNodeTest {

    public static void main(String[] args) {
        String ruleObject = "{\"nodeName\":\"开始\",\"nodeType\":1,\"childers\":[{\"nodeName\":\"本人性别=女\",\"attribute\":[{\"target\":\"self\",\"label\":\"性别\",\"labelCode\":\"gender\",\"operator\":1,\"labelType\":1,\"value\":1}],\"nodeType\":2,\"seq\":1,\"childers\":[{\"nodeName\":\"本人年龄>=22或配偶年龄>=20\",\"attribute\":[{\"target\":\"self\",\"label\":\"年龄\",\"labelCode\":\"age\",\"operator\":2,\"labelType\":1,\"value\":22},{\"target\":\"spouse\",\"label\":\"年龄\",\"labelCode\":\"age\",\"operator\":1,\"labelType\":1,\"value\":20}],\"nodeType\":2,\"seq\":1,\"childers\":[{\"nodeName\":\"本人到展礼分组=3\",\"attribute\":[{\"target\":\"self\",\"label\":\"到展礼分组\",\"labelCode\":\"group\",\"value\":\"3\"}],\"nodeType\":3}]},{\"nodeName\":\"本人年龄<20\",\"attribute\":[{\"target\":\"self\",\"label\":\"年龄\",\"operator\":3,\"labelType\":1,\"value\":20}],\"nodeType\":2,\"seq\":2,\"childers\":[{\"nodeName\":\"本人到展礼分组=2\",\"attribute\":[{\"target\":\"self\",\"label\":\"到展礼分组\",\"labelCode\":\"group\",\"value\":\"2\"}],\"nodeType\":3}]}]},{\"nodeName\":\"本人性别=男\",\"attribute\":[{\"target\":\"self\",\"label\":\"性别\",\"labelCode\":\"gender\",\"operator\":1,\"labelType\":1,\"value\":2}],\"nodeType\":2,\"seq\":2,\"childers\":[{\"nodeName\":\"本人到展礼分组=2\",\"attribute\":[{\"target\":\"self\",\"label\":\"到展礼分组\",\"labelCode\":\"group\",\"value\":\"1\"}],\"nodeType\":3}]}]}";
        RuleTreeDTO tree = JSON.parseObject(ruleObject, RuleTreeDTO.class);
        Map<Integer, RuleNodeDTO> nodeMap = new HashMap<>();
        Integer id = 0;
        analyse(tree, id, 0, nodeMap);
        List<List<RuleNodeDTO>> ruleList = group(nodeMap);
        System.out.println(JSON.toJSONString(ruleList));
    }

    public static Integer analyse(RuleTreeDTO tree, Integer id, Integer parentId, Map<Integer, RuleNodeDTO> nodeMap) {
        Integer currId = id;
        RuleNodeDTO node = new RuleNodeDTO();
        BeanUtils.copyProperties(tree, node);
        node.setId(++currId);
        node.setParentId(parentId);
        nodeMap.put(node.getId(), node);
        if (CollectionUtils.isNotEmpty(tree.getChilders())) {
            for (RuleTreeDTO subTree : tree.getChilders()) {
                currId = analyse(subTree, currId, node.getId(), nodeMap);
            }
        }
        return currId;
    }

    public static List<List<RuleNodeDTO>> group(Map<Integer, RuleNodeDTO> nodeMap) {
        List<List<RuleNodeDTO>> result = new ArrayList<>();
        List<RuleNodeDTO> ruleNodeList = null;
        for (RuleNodeDTO node : nodeMap.values()) {
            if (node.getNodeType() == 3) {
                ruleNodeList = new ArrayList<>();
                addNode(node, ruleNodeList, nodeMap);
                Collections.reverse(ruleNodeList);
                result.add(ruleNodeList);
            }
        }
        return result;
    }

    private static void addNode(RuleNodeDTO node, List<RuleNodeDTO> ruleNodeList, Map<Integer, RuleNodeDTO> nodeMap) {
        RuleNodeDTO copyNode = new RuleNodeDTO();
        BeanUtils.copyProperties(node, copyNode);
        ruleNodeList.add(copyNode);
        if (node.getParentId() != 0) {
            addNode(nodeMap.get(copyNode.getParentId()), ruleNodeList, nodeMap);
        }
    }

}
