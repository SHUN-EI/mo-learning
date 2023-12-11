package com.mo.entity;

/**
 * Created by mo on 2023/12/11
 * 商品信息类
 */
public class Quote {

    /**
     * 商店名称
     */
    private final String shopName;

    /**
     * 商品价格
     */
    private final Double price;

    /**
     * 折扣代码
     */
    private final Discount.Code discountCode;

    /**
     * 将传入的字符串转为商品信息类
     *
     * @param param 格式如 商品名称:价格:折扣代码
     * @return
     */
    public static Quote parse(String param) {

        String[] split = param.split(":");
        String shopName = split[0];
        Double price = Double.parseDouble(split[1]);
        Discount.Code discountCode = Discount.Code.valueOf(split[2]);

        Quote quote = new Quote(shopName, price, discountCode);
        return quote;

    }

    public Quote(String shopName, Double price, Discount.Code discountCode) {
        this.shopName = shopName;
        this.price = price;
        this.discountCode = discountCode;
    }

    public String getShopName() {
        return shopName;
    }

    public Double getPrice() {
        return price;
    }

    public Discount.Code getDiscountCode() {
        return discountCode;
    }
}
