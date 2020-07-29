package com.thoughtworks;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Calculator {
    public int calculatorPoints(ArrayList<Good> goods, BeyondPointRules rules){
        if(rules.isBeyond(goods)){
            return calculatorPointsIsBeyond(goods, rules);
        }else {
            return calculatorPointsNotBeyond(goods, rules);
        }
    }

    public int calculatorPointsNotBeyond(ArrayList<Good> goods, BasicPointRules rules){
        return goods.stream().mapToInt(rules::exchangePoint).sum();
    }

    public int calculatorPointsIsBeyond(ArrayList<Good> goods, BeyondPointRules rules){
        int points;
        BigDecimal benefitGoodsMoney = rules.getBenefitGoodsMoney(goods);
        BigDecimal moneyBoundary = BeyondPointRules.getMoneyBoundary();
        BigDecimal basicRatio = BeyondPointRules.getBasicPointExchangeRatio();
        BigDecimal benefitPRatio = BeyondPointRules.getBenefitPointExchangeRatio();
        BigDecimal beyondRatio = BeyondPointRules.getBeyondBoundaryExchangeRatio();

        if(benefitGoodsMoney.compareTo(BeyondPointRules.getMoneyBoundary())>0) {
            points = moneyBoundary.intValue() * benefitPRatio.intValue();
            points += rules.getGoodsMoney(goods).subtract(benefitGoodsMoney).multiply(beyondRatio).setScale(0,BigDecimal.ROUND_DOWN).intValue();
        }else{
            points = benefitGoodsMoney.intValue() * benefitPRatio.intValue();
            points += (moneyBoundary.subtract(benefitGoodsMoney)).intValue() * basicRatio.intValue();
            points += rules.getGoodsMoney(goods).subtract(moneyBoundary).multiply(beyondRatio).setScale(0,BigDecimal.ROUND_DOWN).intValue();
        }
        return points;
    }
}
