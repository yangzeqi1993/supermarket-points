package com.thoughtworks;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void should_return_total_points_when_calculate_points_given_benefit_goods_money_under_1000(){
        Calculator calculator = new Calculator();
        ArrayList<Good> goods = new ArrayList<>();
        goods.add(new Good(GoodsName.TELEVISION, BigDecimal.valueOf(800)));
        goods.add(new Good(GoodsName.WASHING_MACHINE, BigDecimal.valueOf(2000)));

        BeyondPointRules rules = new BeyondPointRules();


        int totalPoints = calculator.calculatorPoints(goods,rules);

        assertEquals(1890,totalPoints);
    }

    @Test
    public void should_return_total_points_when_calculate_points_given_benefit_goods_money_beyond_1000(){
        Calculator calculator = new Calculator();
        ArrayList<Good> goods = new ArrayList<>();
        goods.add(new Good(GoodsName.TELEVISION, BigDecimal.valueOf(800)));
        goods.add(new Good(GoodsName.TELEVISION, BigDecimal.valueOf(800)));
        goods.add(new Good(GoodsName.WASHING_MACHINE, BigDecimal.valueOf(2000)));

        BeyondPointRules rules = new BeyondPointRules();


        int totalPoints = calculator.calculatorPoints(goods,rules);

        assertEquals(2100,totalPoints);
    }
}
