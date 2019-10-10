package com.zsj.order.service.impl;

import com.zsj.Goods.dao.GoodsRepository;
import com.zsj.Goods.entity.Goods;
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
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    @Resource
    GoodsRepository goodsRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderDTO createOrder(OrderDTO orderDTO) {
        BigDecimal sum = new BigDecimal(0);
        String orderMasterId = Keyutils.genUniqueKey();
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderId(orderMasterId);
        orderMaster.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        orderMasterRepository.save(orderMaster);
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()){
            orderDetail.setId(Keyutils.genUniqueKey());
            orderDetail.setOrderMaster(orderMaster);
            String goodsId = orderDetail.getGoodsId();
            Optional<Goods> goodsOptional = goodsRepository.findById(goodsId);
            if(goodsOptional.isPresent()){
                BigDecimal perPrice = goodsOptional.get().getGoodsPrice();
                sum = sum.add(perPrice.multiply(orderDetail.getGoodsNum()));
            }
            orderDetailRepository.save(orderDetail);
        }
        orderMaster.setOrderPrice(sum);
        orderMasterRepository.save(orderMaster);
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
    @Transactional(rollbackFor = Exception.class)
    public void deleteOrder(String orderId){
        orderMasterRepository.deleteById(orderId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Page<OrderMaster> getOrderList(Pageable pageable){
        return orderMasterRepository.findAll(pageable);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOrderDetail(String orderDetailId, String orderMasterId, BigDecimal goodsNum) {
        BigDecimal sum = new BigDecimal(0);
        orderDetailRepository.updateOrderDetail(orderDetailId, orderMasterId, goodsNum.intValue());
        List<OrderDetail> orderDetails = orderDetailRepository.findByOrderMaterId(orderMasterId);
        for(OrderDetail orderDetail:orderDetails){
            Optional<Goods> goodsOptional = goodsRepository.findById(orderDetail.getGoodsId());
            if(goodsOptional.isPresent()){
                BigDecimal perPrice = goodsOptional.get().getGoodsPrice();
                sum = sum.add(perPrice.multiply(orderDetail.getGoodsNum()));
            }
        }
        orderMasterRepository.updateOrderPrice(orderMasterId, sum.toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteOrderDetail(String orderDetailId, String orderMasterId) {
        BigDecimal sum = new BigDecimal(0);
        orderDetailRepository.deleteOrderDetail(orderDetailId,orderMasterId);
        List<OrderDetail> orderDetails = orderDetailRepository.findByOrderMaterId(orderMasterId);
        for(OrderDetail orderDetail:orderDetails){
            Optional<Goods> goodsOptional = goodsRepository.findById(orderDetail.getGoodsId());
            if(goodsOptional.isPresent()){
                BigDecimal perPrice = goodsOptional.get().getGoodsPrice();
                sum = sum.add(perPrice.multiply(orderDetail.getGoodsNum()));
            }
        }
        orderMasterRepository.updateOrderPrice(orderMasterId, sum.toString());
    }
}
