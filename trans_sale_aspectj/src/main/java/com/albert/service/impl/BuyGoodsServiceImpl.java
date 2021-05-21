package com.albert.service.impl;

import com.albert.dao.GoodsDao;
import com.albert.dao.SaleDao;
import com.albert.entity.Goods;
import com.albert.entity.Sale;
import com.albert.excep.NotEnoughException;
import com.albert.service.BuyGoodsService;

public class BuyGoodsServiceImpl implements BuyGoodsService {

    // Dao属性
    private GoodsDao goodsDao;
    private SaleDao saleDao;

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    @Override
    public void buy(Integer goodsId, Integer amount) {

        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(amount);
        int res = saleDao.insertSale(sale);

        Goods goods = goodsDao.selectGoods(goodsId);
        if (goods == null){
            throw new NullPointerException("无此商品");
        }
        if (goods.getAmount() < amount){
            throw  new NotEnoughException("商品不足");
        }

        goods = new Goods();
        goods.setId(goodsId);
        goods.setAmount(amount);
        int res2 = goodsDao.updateGoods(goods);



    }
}
