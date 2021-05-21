package com.albert;

import com.albert.service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BuyGoodsServiceTest {

    @Test
    public void testBuy(){
        String resource = "classpath:applicationContext.xml";

        ApplicationContext ac = new ClassPathXmlApplicationContext(resource);

        BuyGoodsService bgs = (BuyGoodsService) ac.getBean("buyGoodsService");

        bgs.buy(1001,200);
    }
}
