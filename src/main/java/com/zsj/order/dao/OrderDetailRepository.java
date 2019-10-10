package com.zsj.order.dao;

import com.zsj.order.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


/**
 * @author zsj
 * @date 2019.9.30
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    /**
     * 修改订单详情表中商品数量
     * @param orderDetailId 订单详情表id
     * @param orderMasterId 订单主表id
     * @param goodsNum 修改商品数量
     */
    @Modifying
    @Query(value = "UPDATE order_detail SET goods_num=?3 WHERE id=?1 AND order_id=?2", nativeQuery = true)
    void updateOrderDetail(String orderDetailId, String orderMasterId, int goodsNum);

    /**
     * 删除订单详情表中的数据
     * @param orderDetailId 订单详情表id
     * @param orderMasterId 订单主表id
     */
    @Modifying
    @Query(value = "DELETE FROM order_detail WHERE id=?1 AND order_id=?2", nativeQuery = true)
    void deleteOrderDetail(String orderDetailId, String orderMasterId);
}
