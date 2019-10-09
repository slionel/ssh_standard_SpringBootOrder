package com.zsj.product.service;

import com.zsj.product.dao.GoodsRepository;
import com.zsj.product.entity.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zsj
 * @date 2019.9.23
 */

@Service
public class GoodsService {
    @Resource
    GoodsRepository goodsRepository;

    public Goods addGoods(Goods goods){
        return goodsRepository.save(goods);
    }

    public void deleteGoods(String goodsId){
        goodsRepository.deleteById(goodsId);
    }

    public Goods updateGoods(Goods goods){
        return goodsRepository.save(goods);
    }

    public Page<Goods> getGoodsList(Pageable pageable){
        return goodsRepository.findAll(pageable);
    }
}
