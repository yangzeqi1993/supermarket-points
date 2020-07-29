package com.thoughtworks;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BeyondPointRulesTest {

    @Test
    public void should_return_true_when_use_function_isPromotional_given_apple(){
        BeyondPointRules beyondRules = new BeyondPointRules();
        Good apple = new Good(GoodsName.APPLE, BigDecimal.valueOf(100));

        boolean isTrue =  beyondRules.isPromotional(apple);

        assertTrue(isTrue);
    }

    @Test
    public void should_return_points_when_use_function_exchangePoint_given_refrigerator(){
        BeyondPointRules beyondRules = new BeyondPointRules();
        Good refrigerator = new Good(GoodsName.REFRIGERATOR, BigDecimal.valueOf(700));

        int points =  beyondRules.exchangePoint(refrigerator);

        assertEquals(1400,points);
    }

    @Test
    public void should_return_goods_money_when_use_function_getGoodsMoney_given_goods(){
        BeyondPointRules beyondRules = new BeyondPointRules();
        ArrayList<Good> goods = new ArrayList<>();
        goods.add(new Good(GoodsName.APPLE, BigDecimal.valueOf(100)));
        goods.add(new Good(GoodsName.REFRIGERATOR, BigDecimal.valueOf(700)));
        goods.add(new Good(GoodsName.BEEF, BigDecimal.valueOf(150)));


        BigDecimal goodsMoney = beyondRules.getGoodsMoney(goods);

        assertEquals(BigDecimal.valueOf(950),goodsMoney);
    }

    @Test
    public void should_return_true_when_use_function_isBeyond_given_goods_money_is_1050(){
        BeyondPointRules beyondRules = new BeyondPointRules();
        ArrayList<Good> goods = new ArrayList<>();
        goods.add(new Good(GoodsName.REFRIGERATOR, BigDecimal.valueOf(700)));
        goods.add(new Good(GoodsName.BEEF, BigDecimal.valueOf(150)));
        goods.add(new Good(GoodsName.WASHING_LIQUID, BigDecimal.valueOf(200)));


        boolean isTrue = beyondRules.isBeyond(goods);

        assertTrue(isTrue);
    }

    @Test
    public void should_return_false_when_use_function_isBeyond_given_goods_money_is_950(){
        BeyondPointRules beyondRules = new BeyondPointRules();
        ArrayList<Good> goods = new ArrayList<>();
        goods.add(new Good(GoodsName.REFRIGERATOR, BigDecimal.valueOf(700)));
        goods.add(new Good(GoodsName.BEEF, BigDecimal.valueOf(150)));
        goods.add(new Good(GoodsName.APPLE, BigDecimal.valueOf(100)));


        boolean isFalse = beyondRules.isBeyond(goods);

        assertFalse(isFalse);
    }
}
