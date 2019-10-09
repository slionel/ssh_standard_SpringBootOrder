package com.zsj.order.dao;

import com.zsj.order.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zsj
 * @date 2019.9.23
 */

public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}
