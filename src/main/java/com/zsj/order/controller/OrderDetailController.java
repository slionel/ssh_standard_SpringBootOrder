package com.zsj.order.controller;

import com.zsj.order.service.OrderService;
import com.zsj.utils.ResultVoUtil;
import com.zsj.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author zsj
 * @date 2019.10.10
 */
@Api(value = "订单详情表Controller")
@Slf4j
@RestController
@RequestMapping("odc")
public class OrderDetailController {
    @Resource
    OrderService orderService;

    @ApiOperation(value = "修改订单详情表", notes = "地址传值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderDetailId", value = "订单详情表id", required = true, dataType = "String"),
            @ApiImplicitParam(name = "orderMasterId", value = "订单主表id", required = true, dataType = "String"),
            @ApiImplicitParam(name = "goodsNum", value = "修改的商品数量", required = true, dataType = "String")
    })
    @PutMapping("updateOrderDetail/{orderDetailId}/{orderMasterId}/{goodsNum}")
    public ResultVo updateOrderDetail(
            @PathVariable(name = "orderDetailId") String orderDetailId,
            @PathVariable(name = "orderMasterId") String orderMasterId,
            @PathVariable(name = "goodsNum") String goodsNum
    )
    {
        orderService.updateOrderDetail(orderDetailId, orderMasterId, new BigDecimal(goodsNum));
        return ResultVoUtil.success();
    }

    @ApiOperation(value = "删除订单详情表中记录", notes = "地址传值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderDetailId", value = "订单详情表id", required = true, dataType = "String"),
            @ApiImplicitParam(name = "orderMasterId", value = "订单主表id", required = true, dataType = "String")
    })
    @DeleteMapping("deleteOrderDetail/{orderDetailId}/{orderMasterId}")
    public ResultVo deleteOrderDetail(
            @PathVariable(name = "orderDetailId") String orderDetailId,
            @PathVariable(name = "orderMasterId") String orderMasterId
    )
    {
        orderService.deleteOrderDetail(orderDetailId, orderMasterId);
        return ResultVoUtil.success();
    }
}
