package com.zsj.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

/**
 * @author zsj
 */
@Data
public class OrderForm {

    /**
     * 订单名
     */
    @NotEmpty(message = "订单名不能为空")
    private String orderName;

    /**
     * 订单创建时间
     */
    @NotEmpty(message = "订单创建时间不能为空")
    private String createTime;

    /**
     * 用户id
     */
    @NotEmpty(message = "用户id不能为空")
    private String customerId;

    /**
     * 订单完成时间
     */

    private String completeTime;

    /**
     * 订单状态
     */
    private String status;

    /**
     * 订单内容
     */
    private String orderDetailList;
}
