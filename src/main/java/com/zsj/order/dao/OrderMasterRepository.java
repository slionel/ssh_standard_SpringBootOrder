package com.zsj.order.dao;

import com.zsj.order.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author zsj
 * @date 2019.9.23
 */

public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
    /**
     * @param orderPrice
     */
    @Modifying
    @Query(value = "UPDATE order_master SET order_price=?2 WHERE order_id=?1", nativeQuery = true)
    void updateOrderPrice(String orderMasterId, String orderPrice);
}
