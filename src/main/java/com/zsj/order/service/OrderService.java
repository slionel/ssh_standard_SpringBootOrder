package com.zsj.order.service;

import com.zsj.dto.OrderDTO;
import com.zsj.order.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author zsj
 * @date 2019.9.23
 */
@Service
public interface OrderService {
    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO createOrder(OrderDTO orderDTO);

    /**
     * 更新订单
     * @param orderDTO
     * @param id
     * @return
     */
    OrderMaster updateOrder(OrderDTO orderDTO, String id);

    /**
     * 删除订单
     * @param orderId
     */
    void deleteOrder(String orderId);

    /**
     * 获取所有订单
     * @param pageable
     * @return
     */
    Page<OrderMaster> getOrderList(Pageable pageable);
}
