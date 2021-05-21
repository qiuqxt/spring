package com.albert.dao;

import com.albert.entity.Goods;

public interface GoodsDao {

    int updateGoods(Goods goods);
    Goods selectGoods(Integer goodsId);
}
