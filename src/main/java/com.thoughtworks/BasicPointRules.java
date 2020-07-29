package com.thoughtworks;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class BasicPointRules {
    private static final BigDecimal BASIC_POINT_EXCHANGE_RATIO = BigDecimal.valueOf(1);
    private static final BigDecimal BENEFIT_POINT_EXCHANGE_RATIO = BigDecimal.valueOf(2);
    private List<GoodsName> basicTaxFreeGoodsTypes = Arrays.asList(GoodsName.APPLE, GoodsName.WATERMELON, GoodsName.REFRIGERATOR);

    public int exchangePoint(Good good){
        BigDecimal pointExchangeRatio;
        if(isPromotional(good)){
            pointExchangeRatio = BENEFIT_POINT_EXCHANGE_RATIO;
        }else {
            pointExchangeRatio = BASIC_POINT_EXCHANGE_RATIO;
        }
        return good.getPrice().multiply(pointExchangeRatio).intValue();
    }

    public boolean isPromotional(Good good){return  basicTaxFreeGoodsTypes.contains(good.getName());}
}
