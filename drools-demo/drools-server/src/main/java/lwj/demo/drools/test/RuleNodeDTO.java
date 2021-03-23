package lwj.demo.drools.test;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class RuleNodeDTO implements Serializable {

    private static final long serialVersionUID = -5478837177521946848L;

    private Integer id;

    private Integer parentId;

    private String nodeName;

    private Integer nodeType;

    private List<RuleAttributeDTO> attribute;

}
