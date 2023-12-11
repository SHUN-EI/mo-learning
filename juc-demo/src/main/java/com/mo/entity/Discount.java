package com.mo.entity;

import cn.hutool.core.util.RandomUtil;

import java.util.concurrent.TimeUnit;

/**
 * Created by mo on 2023/12/11
 * 折扣类
 */
public class Discount {

    //折扣枚举
    public enum Code {
        NONE(0), //不打折
        SILVER(5), //打九五折
        GOLD(10), //打九折
        PLATINUM(15), //打八五折
        DIAMOND(20);//打八折

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    /**
     * 计算折扣价
     * @param price
     * @param code
     * @return
     */
    private static int apply(Double price, Code code) {
        //模拟远程调用耗时
        try {
            TimeUnit.MILLISECONDS.sleep(RandomUtil.randomInt(500, 2500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double result = price * (100 - code.percentage) / 100;

        return (int) result;

    }

    /**
     * 传入商品信息类 返回折扣后的价格
     * 返回折后价
     *
     * @param quote
     * @return
     */
    public static String applyDiscount(Quote quote) {

        String result = quote.getShopName() + "price is " + Discount.apply(quote.getPrice(), quote.getDiscountCode());

        return result;
    }
}
