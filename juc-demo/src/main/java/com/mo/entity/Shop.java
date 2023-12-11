package com.mo.entity;

import cn.hutool.core.util.RandomUtil;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by mo on 2023/12/11
 * 商店类
 */
public class Shop {

    private String name;

    private Random random;

    public Shop(String name) {
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public String getName() {
        return name;
    }


    /**
     * 传入产品名称返回对应价格和折扣代码
     * @param product 商品名
     * @return  商品名:价格:折扣代码
     */
    public String getPrice(String product) {
        Double price = calculatePrice(product);

        int num = random.nextInt(Discount.Code.values().length);
        Discount.Code code = Discount.Code.values()[num];

        return name + ":" + price + ":" + code;

    }

    /**
     * 获取商品价格
     *
     * @param product
     * @return
     */
    public Double calculatePrice(String product) {

        try {
            //模拟远程调用等待
            TimeUnit.MILLISECONDS.sleep(RandomUtil.randomInt(500, 2500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double price = random.nextDouble() * product.charAt(0) + product.charAt(1);

        return price;
    }


}
