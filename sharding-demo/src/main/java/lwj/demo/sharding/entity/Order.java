package lwj.demo.sharding.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Order implements Serializable {

    private static final long serialVersionUID = 2008883833325217520L;

    private Long orderId;

    private Long userId;
}