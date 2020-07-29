package com.thoughtworks;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BeyondPointRules extends BasicPointRules{
    private static final BigDecimal MONEY_BOUNDARY = BigDecimal.valueOf(1000);
    private static final BigDecimal BEYOND_BOUNDARY_EXCHANGE_RATIO = BigDecimal.valueOf(1/20);

    public BeyondPointRules() {
        super();
    }

    public boolean isBeyond(ArrayList<Good> goods){
        return getGoodsMoney(goods).compareTo(MONEY_BOUNDARY) > 0;
    }

    public BigDecimal getGoodsMoney(ArrayList<Good> goods){
        BigDecimal goodsMoney = BigDecimal.ZERO;
        for (Good good : goods) goodsMoney = goodsMoney.add(good.getPrice());
        return goodsMoney;
    }
}
