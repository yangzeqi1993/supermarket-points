package com.thoughtworks;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PointActivity {
    private static final BigDecimal BASIC_POINT_EXCHANGE_RATE = BigDecimal.valueOf(1);
    private static final BigDecimal BENEFIT_POINT_EXCHANGE_RATE = BigDecimal.valueOf(2);
    private List<GoodsName> basicTaxFreeGoodsTypes = Arrays.asList(GoodsName.APPLE, GoodsName.WATERMELON, GoodsName.REFRIGERATOR);

    public int exchangePoint(Good good){return 0;}

    public boolean isPromotional(Good good){return  basicTaxFreeGoodsTypes.contains(good.getName());}
}
