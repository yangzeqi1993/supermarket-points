package com.thoughtworks;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BeyondPointRules extends BasicPointRules{
    private static final BigDecimal MONEY_BOUNDARY = BigDecimal.valueOf(1000);
    private static final BigDecimal BEYOND_BOUNDARY_EXCHANGE_RATIO = BigDecimal.valueOf(0.05);

    public BeyondPointRules() {
        super();
    }

    public static BigDecimal getBeyondBoundaryExchangeRatio() {
        return BEYOND_BOUNDARY_EXCHANGE_RATIO;
    }

    public static BigDecimal getMoneyBoundary() {
        return MONEY_BOUNDARY;
    }

    public boolean isBeyond(ArrayList<Good> goods){
        return getGoodsMoney(goods).compareTo(MONEY_BOUNDARY) > 0;
    }

    public BigDecimal getGoodsMoney(ArrayList<Good> goods){
        BigDecimal goodsMoney = BigDecimal.ZERO;
        for (Good good : goods) goodsMoney = goodsMoney.add(good.getPrice());
        return goodsMoney;
    }

    public BigDecimal getBenefitGoodsMoney(ArrayList<Good> goods){
        BigDecimal benefitGoodsMoney = BigDecimal.ZERO;
        for (Good good : goods)
            if (super.isPromotional(good)) {
                benefitGoodsMoney = benefitGoodsMoney.add(good.getPrice());
            }
        return benefitGoodsMoney;
    }
}
