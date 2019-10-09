package com.zsj.Goods.dao;

import com.zsj.Goods.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zsj
 * @date 2019.9.23
 */

public interface GoodsRepository extends JpaRepository<Goods, String> {

}
