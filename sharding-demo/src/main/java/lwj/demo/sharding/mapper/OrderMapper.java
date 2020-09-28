package lwj.demo.sharding.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lwj.demo.sharding.entity.Order;

public interface OrderMapper {

    public Integer insertOrder(@Param("userId") Long userId);

    public List<Order> getById(@Param("userId") Long userId);

}