package com.zsj.dto;


import com.zsj.order.entity.OrderDetail;
import com.zsj.order.entity.OrderMaster;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 作为前端和后端的数据传输
 * @author zsj
 */
@Data
public class OrderDTO {

    private String orderId;

    private String orderName;

    private String createTime;

    private String customerId;

    private BigDecimal orderPrice;

    private String completeTime;

    private String status;

    private List<OrderDetail> orderDetailList;

}
