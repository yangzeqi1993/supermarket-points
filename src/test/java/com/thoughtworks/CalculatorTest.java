package com.thoughtworks;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalculatorTest {
    @Test
    public void should_return_total_points_when_calculate_points_given_goods(){
        Calculator calculator = new Calculator();
        ArrayList<Good> goods = new ArrayList<>();
        goods.add(new Good(GoodsName.APPLE, BigDecimal.valueOf(100)));
        goods.add(new Good(GoodsName.REFRIGERATOR, BigDecimal.valueOf(700)));
        goods.add(new Good(GoodsName.BEEF, BigDecimal.valueOf(150)));


        int totalPoints = calculator.calculatorPoints(goods);

        assertEquals(1050,totalPoints);
    }
}
