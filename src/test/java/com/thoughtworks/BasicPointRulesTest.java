package com.thoughtworks;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BasicPointRulesTest {
    @Test
    public void should_return_true_when_use_function_isPromotional_given_apple(){
        BasicPointRules basicRules = new BasicPointRules();
        Good apple = new Good(GoodsName.APPLE, BigDecimal.valueOf(100));

        boolean isTrue =  basicRules.isPromotional(apple);

        assertTrue(isTrue);
    }

    @Test
    public void should_return_points_when_use_function_exchangePoint_given_refrigerator(){
        BasicPointRules basicRules = new BasicPointRules();
        Good refrigerator = new Good(GoodsName.REFRIGERATOR, BigDecimal.valueOf(700));

        int points =  basicRules.exchangePoint(refrigerator);

        assertEquals(1400,points);
    }
}
