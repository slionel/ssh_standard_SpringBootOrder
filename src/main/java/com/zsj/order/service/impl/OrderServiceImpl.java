package com.zsj.order.service.impl;

import com.zsj.dto.OrderDTO;
import com.zsj.order.dao.OrderDetailRepository;
import com.zsj.order.dao.OrderMasterRepository;
import com.zsj.order.entity.OrderDetail;
import com.zsj.order.entity.OrderMaster;
import com.zsj.order.service.OrderService;
import com.zsj.utils.Keyutils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @author zsj
 * @date 2019.9.23
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMasterRepository orderMasterRepository;
    @Resource
    OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        String orderMasterId = Keyutils.genUniqueKey();
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderId(orderMasterId);
        orderMasterRepository.save(orderMaster);
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()){
            orderDetail.setId(Keyutils.genUniqueKey());
            orderDetail.setOrderMaster(orderMaster);
            orderDetailRepository.save(orderDetail);
        }


        orderDTO.setOrderId(orderMasterId);
        return orderDTO;
    }

    @Override
    public OrderMaster updateOrder(OrderDTO orderDTO, String id){
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderId(id);
        return orderMasterRepository.save(orderMaster);
    }

    @Override
    public void deleteOrder(String orderId){
        orderMasterRepository.deleteById(orderId);
    }

    @Override
    public Page<OrderMaster> getOrderList(Pageable pageable){
        Page<OrderMaster> page = orderMasterRepository.findAll(pageable);
        return page;
    }
}
