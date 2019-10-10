package com.zsj.order.controller;

import com.zsj.order.service.OrderService;
import com.zsj.utils.ResultVoUtil;
import com.zsj.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author zsj
 * @date 2019.10.10
 */
@Slf4j
@RestController
@RequestMapping("odc")
public class OrderDetailController {
    @Resource
    OrderService orderService;

    @PutMapping("updateOrderDetail/{orderDetailId}/{orderMasterId}/{goodsNum}")
    public ResultVo updateOrderDetail(@PathVariable(name = "orderDetailId") String orderDetailId,
                                                                @PathVariable(name = "orderMasterId") String orderMasterId,
                                                                @PathVariable(name = "goodsNum") String goodsNum){
        orderService.updateOrderDetail(orderDetailId, orderMasterId, new BigDecimal(goodsNum));
        return ResultVoUtil.success();
    }
}
