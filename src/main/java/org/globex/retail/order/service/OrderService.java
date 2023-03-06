package org.globex.retail.order.service;

import io.smallrye.common.annotation.Blocking;
import org.globex.retail.order.model.dto.OrderDto;
import org.globex.retail.order.model.dto.OrderMapper;
import org.globex.retail.order.model.entity.Order;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class OrderService {

    @Transactional
    @Blocking
    public OrderDto storeOrder(OrderDto orderDto) {
        Order order = OrderMapper.toEntity(orderDto);
        order.persist();
        return OrderMapper.toDto(order);
    }

}
