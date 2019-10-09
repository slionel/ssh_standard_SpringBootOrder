package com.zsj.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zsj.dto.OrderDTO;
import com.zsj.exception.DataValidationException;
import com.zsj.form.OrderForm;
import com.zsj.order.entity.OrderDetail;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zsj
 * @date 2019.9.30
 */
@Slf4j
public class OrderFormToOrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderName(orderForm.getOrderName());
        orderDTO.setCreateTime(orderForm.getCreateTime());
        orderDTO.setCustomerId(orderForm.getCustomerId());
        orderDTO.setCompleteTime(orderForm.getCompleteTime());
        orderDTO.setStatus(orderForm.getStatus());

        List<OrderDetail> orderDetails = new ArrayList<>();
        try{
            orderDetails = gson.fromJson(orderForm.getOrderDetailList(),
                    new TypeToken<List<OrderDetail>>(){
                    }.getType());
        }catch (Exception e){
            log.error("【对象转换】错误, string={}", orderForm.getOrderDetailList());
            throw new DataValidationException("对象转换");
        }
        orderDTO.setOrderDetailList(orderDetails);

        return orderDTO;
    }
}
