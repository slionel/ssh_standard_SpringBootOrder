package com.zsj.order.dao;

import com.zsj.order.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zsj
 * @date 2019.9.30
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

}
