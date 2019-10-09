package com.zsj.product.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zsj
 * @date 2019.9.24
 */

@Entity
public class Goods implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @Column(length = 50)
    private String goodsId;

    private String goodsName;

    private String goodsCategory;

    private String goodsProduceDate;

    private String goodsShelfLife;

    private int goodsQuantity;

    private BigDecimal goodsPrice;

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(String goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public String getGoodsProduceDate() {
        return goodsProduceDate;
    }

    public void setGoodsProduceDate(String goodsProduceDate) {
        this.goodsProduceDate = goodsProduceDate;
    }

    public String getGoodsShelfLife() {
        return goodsShelfLife;
    }

    public void setGoodsShelfLife(String goodsShelfLife) {
        this.goodsShelfLife = goodsShelfLife;
    }

    public int getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(int goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
