package com.zsj.order.controller;

import com.zsj.dto.OrderDTO;
import com.zsj.exception.DataValidationException;
import com.zsj.form.OrderForm;
import com.zsj.order.entity.OrderMaster;
import com.zsj.order.service.OrderService;
import com.zsj.utils.OrderFormToOrderDTOConverter;
import com.zsj.utils.ResultVoUtil;
import com.zsj.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.*;

/**
 * @author zsj
 * @date 2019.9.23
 */
@Api(value = "订单主表Controller")
@Slf4j
@Controller
@RequestMapping("omc")
public class OrderMasterController {

    @Resource
    OrderService orderService;

    @ApiOperation(value = "新建订单", notes = "以表单形式传值")
    @ApiImplicitParam(name = "orderForm", value = "订单表单实体", required = true, dataType = "OrderForm")
    @PostMapping("createOrder")
    @ResponseBody
    public ResultVo<Map<String,String>> createOrder(@Valid OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new DataValidationException(bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderFormToOrderDTOConverter.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车不能为空");
            throw new DataValidationException("购物车不能为空");
        }
        OrderDTO result = orderService.createOrder(orderDTO);

        Map<String,String> map = new HashMap<>(1);
        map.put("OrderMasterId",result.getOrderId());
        return ResultVoUtil.success(map);
    }

    @ApiOperation(value = "更新订单，OrderMaster", notes = "form表单传值，地址传值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderForm", value = "订单表单实体", required = true, dataType = "OrderForm"),
            @ApiImplicitParam(name = "orderId", value = "订单主表id", required = true, dataType = "String")
    })
    @PutMapping("updateOrder/{orderId}")
    @ResponseBody
    public ResultVo<Map<String,String>> updateOrder(OrderForm orderForm, @PathVariable(name = "orderId") String orderId){
        OrderDTO orderDTO = OrderFormToOrderDTOConverter.convert(orderForm);
        orderService.updateOrder(orderDTO, orderId);
        return ResultVoUtil.success();
    }

    @ApiOperation(value = "删除订单", notes = "地址传值")
    @ApiImplicitParam(name = "orderId", value = "订单主表id", required = true, dataType = "String")
    @DeleteMapping("deleteOrder/{orderId}")
    @ResponseBody
    public ResultVo deleteOrder(@PathVariable(name = "orderId") String orderId){
        orderService.deleteOrder(orderId);
        return ResultVoUtil.success();
    }

    @ApiOperation(value = "分页查询订单", notes = "地址传值")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "pageNo", value = "显示页数", required = true, dataType = "Integer"),
                    @ApiImplicitParam(name = "pageSize", value = "每页显示数量", required = true, dataType = "Integer")
            }
    )
    @GetMapping("getOrderList/{pageNo}/{pageSize}")
    @ResponseBody
    public ResultVo<Page<OrderMaster>> getOrderList(@PathVariable(name = "pageNo") int pageNo, @PathVariable(name = "pageSize") int pageSize){
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return ResultVoUtil.success(orderService.getOrderList(pageable));
    }
}
