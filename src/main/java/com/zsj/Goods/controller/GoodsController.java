package com.zsj.Goods.controller;

import com.zsj.Goods.entity.Goods;
import com.zsj.Goods.service.GoodsService;
import com.zsj.utils.Keyutils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zsj
 * @date 2019.9.24
 */

@Api("商品Controller相关Api")
@Controller
@RequestMapping("gc")
public class GoodsController {
    @Resource
    GoodsService goodsService;

    @ApiOperation(value = "添加商品", notes = "添加商品")
    @ApiImplicitParam(name = "goods", value = "商品类", required = true, dataType = "Goods", paramType = "Goods")
    @PostMapping("addGoods")
    @ResponseBody
    public Map addGoods(@RequestBody Goods goods){
        Map<String,Goods> map = new HashMap<>(1);
        goods.setGoodsId(Keyutils.genUniqueKey());
        map.put("rs",goodsService.addGoods(goods));
        return map;
    }

    @DeleteMapping("deleteGoods/{goodsId}")
    @ApiImplicitParam(name = "goodId", value = "商品id", required = true, dataType = "String", paramType = "path")
    @ResponseBody
    public Map deleteGoods(@PathVariable(name = "goodsId") String goodsId){
        Map<String,Integer> map = new HashMap<>(1);
        goodsService.deleteGoods(goodsId);
        map.put("rs",1);
        return map;
    }

    @PutMapping("updateGoods")
    @ApiImplicitParam(name = "goods", value = "商品类", required = true, dataType = "Goods", paramType = "Goods")
    @ResponseBody
    public Map updateGoods(@RequestBody Goods goods){
        Map<String, Goods> map = new HashMap<>(1);
        map.put("rs",goodsService.updateGoods(goods));
        return map;
    }

    @GetMapping("getGoodsList/{pageNo}/{pageSize}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "页面显示数量", required = true, dataType = "int", paramType = "path")
    }
    )

    @ResponseBody
    public Page<Goods> getGoodsList(@PathVariable(name = "pageNo") int pageNo, @PathVariable(name = "pageSize") int pageSize){
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return goodsService.getGoodsList(pageable);
    }
}
