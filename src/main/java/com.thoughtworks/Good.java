package com.thoughtworks;

import java.math.BigDecimal;

public class Good {
    private GoodsName name;
    private BigDecimal price;

    public Good(GoodsName name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public GoodsName getName() {
        return name;
    }
}
