package lwj.demo.drools.test;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class RuleTreeDTO implements Serializable {

    private static final long serialVersionUID = -5478837177521946848L;

    private String nodeName;

    private Integer nodeType;

    private Integer seq;

    private List<RuleAttributeDTO> attribute;

    private List<RuleTreeDTO> childers;
}
