package com.zsj.order.service;

import com.zsj.dto.OrderDTO;
import com.zsj.order.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author zsj
 * @date 2019.9.23
 */
@Service
public interface OrderService {
    /**
     * 创建orderMaster, orderDetail
     * @param orderDTO
     * @return
     */
    OrderDTO createOrder(OrderDTO orderDTO);

    /**
     * 更新orderMaster
     * @param orderDTO
     * @param id
     * @return
     */
    OrderMaster updateOrder(OrderDTO orderDTO, String id);

    /**
     * 删除orderMaster
     * @param orderId
     */
    void deleteOrder(String orderId);

    /**
     * 获取所有orderMaster
     * @param pageable
     * @return
     */
    Page<OrderMaster> getOrderList(Pageable pageable);

    /**
     * 修改订单详情表数据
     * @param orderDetailId 订单详情表id
     * @param orderMasterId 订单主表id
     * @param goodsNum 修改商品数量
     * @return
     */
    void updateOrderDetail(String orderDetailId, String orderMasterId, BigDecimal goodsNum);

    /**
     * 删除订单详情表中的数据
     * @param orderDetailId 订单详情表id
     * @param orderMasterId 订单主表id
     */
    void deleteOrderDetail(String orderDetailId, String orderMasterId);
}
