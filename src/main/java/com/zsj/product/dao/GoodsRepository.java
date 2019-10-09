package com.zsj.product.dao;

import com.zsj.product.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zsj
 * @date 2019.9.23
 */

public interface GoodsRepository extends JpaRepository<Goods, String> {

}
