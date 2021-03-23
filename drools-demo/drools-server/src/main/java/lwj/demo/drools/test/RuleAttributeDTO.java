package lwj.demo.drools.test;

import java.io.Serializable;

import lombok.Data;

@Data
public class RuleAttributeDTO implements Serializable {

    private static final long serialVersionUID = -5478837177521946848L;

    private String target;

    private String label;

    private String labelCode;

    private Integer operator;

    private Integer labelType;

    private Integer value;
}
