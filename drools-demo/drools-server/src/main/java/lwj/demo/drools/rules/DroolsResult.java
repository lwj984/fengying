package lwj.demo.drools.rules;

import java.io.Serializable;

import lombok.Data;

@Data
public class DroolsResult implements Serializable {

    private static final long serialVersionUID = 8099618787856402429L;

    private String factId;

    private Integer resultInt;

    private String resultStr;

}
