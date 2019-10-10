package com.zsj.order.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author zsj
 * @date 2019.9.23
 */
@Entity
@Data
public class OrderMaster implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @Column(length = 50)
    private String orderId;

    private String orderName;

    private String createTime;

    private String customerId;

    private BigDecimal orderPrice;

    private String completeTime;

    private String status;

    @OneToMany(mappedBy = "orderMaster", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<OrderDetail> orderDetailArrayList;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
