package com.thoughtworks;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class RulesTest {
    @Test
    public void should_return_goods_money_when_use_function_getGoodsMoney_given_goods(){
        Rules rules = new Rules();
        ArrayList<Good> goods = new ArrayList<>();
        goods.add(new Good(GoodsName.APPLE, BigDecimal.valueOf(100)));
        goods.add(new Good(GoodsName.REFRIGERATOR, BigDecimal.valueOf(700)));
        goods.add(new Good(GoodsName.BEEF, BigDecimal.valueOf(150)));


        BigDecimal goodsMoney = rules.getGoodsMoney(goods);

        assertEquals(BigDecimal.valueOf(950),goodsMoney);
    }

    @Test
    public void should_return_true_when_use_function_isBeyond_given_goods_money_is_1050(){
        Rules rules = new Rules();
        ArrayList<Good> goods = new ArrayList<>();
        goods.add(new Good(GoodsName.REFRIGERATOR, BigDecimal.valueOf(700)));
        goods.add(new Good(GoodsName.BEEF, BigDecimal.valueOf(150)));
        goods.add(new Good(GoodsName.WASHING_LIQUID, BigDecimal.valueOf(200)));


        boolean isTrue = rules.isBeyond(goods);

        assertTrue(isTrue);
    }

    @Test
    public void should_return_false_when_use_function_isBeyond_given_goods_money_is_950(){
        Rules rules = new Rules();
        ArrayList<Good> goods = new ArrayList<>();
        goods.add(new Good(GoodsName.REFRIGERATOR, BigDecimal.valueOf(700)));
        goods.add(new Good(GoodsName.BEEF, BigDecimal.valueOf(150)));
        goods.add(new Good(GoodsName.APPLE, BigDecimal.valueOf(100)));


        boolean isFalse = rules.isBeyond(goods);

        assertFalse(isFalse);
    }
}
