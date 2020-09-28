package lwj.demo.sharding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lwj.demo.sharding.entity.Order;
import lwj.demo.sharding.mapper.OrderMapper;

@Service
public class OrderService {

    @Autowired
    private OrderMapper mapper;

    public Integer add(Long userId) {
        return mapper.insertOrder(userId);
    }

    public List<Order> getById(Long userId) {
        return mapper.getById(userId);
    }

}
