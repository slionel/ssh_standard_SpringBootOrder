package com.zsj.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * @author zsj
 * @date 2019.9.25
 */
@Entity
@Data
@RequiredArgsConstructor
public class OrderDetail {
    @Id
    @Column(length = 50)
    private String id;
    private String goodsId;
    private String goodsNum;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderMaster orderMaster;

}
