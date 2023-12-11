package com.mo;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import cn.hutool.json.JSONUtil;
import com.mo.entity.Discount;
import com.mo.entity.Quote;
import com.mo.entity.Shop;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


/**
 * Created by mo on 2023/12/11
 */
public class ProductTest {

    private final static List<Shop> SHOPS = Arrays.asList(
            new Shop("Nike"),
            new Shop("Adidas"),
            new Shop("ANTA"),
            new Shop("Li-Ning"),
            new Shop("PEAK"),
            new Shop("Under-Armour"),
            new Shop("PUMA")
    );

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6,
            8,
            1,
            TimeUnit.MINUTES,
            new ArrayBlockingQueue<>(100),
            new ThreadFactoryBuilder().setNamePrefix("threadPool-%d").build());


    /**
     * 使用CompletableFuture+自定义线程池
     *
     * @param args
     */
    public static void main(String[] args) {

        String product = "AJ basketball shoes";


        long begin = System.currentTimeMillis();
        List<String> productList = SHOPS.stream()
                //到每一个商店获取价格，返回商品名:价格:折扣代码 给下一个流，该方法有随机耗时
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), threadPoolExecutor))
                //上一个异步任务完成后,再异步生成商品信息对象
                .map(future -> future.thenApply(Quote::parse))
                //上一个任务完成后生成一个计算折扣价的异步任务对象 CompletableFuture
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), threadPoolExecutor)))
                //生成异步任务的列表
                .collect(Collectors.toList())
                .stream()
                //阻塞获取每一个任务的结果
                .map(CompletableFuture::join)
                //生成list
                .collect(Collectors.toList());

        System.out.println(JSONUtil.toJsonStr(productList));
        System.out.println("查询结束，总耗时:" + (System.currentTimeMillis() - begin) + "ms");


    }

    /**
     * 使用CompletableFuture
     *
     * @param args
     */
    public static void main3(String[] args) {

        String product = "AJ basketball shoes";


        long begin = System.currentTimeMillis();
        List<String> productList = SHOPS.stream()
                //到每一个商店获取价格，返回商品名:价格:折扣代码 给下一个流，该方法有随机耗时
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product)))
                //上一个异步任务完成后,再异步生成商品信息对象
                .map(future -> future.thenApply(Quote::parse))
                //上一个任务完成后生成一个计算折扣价的异步任务对象 CompletableFuture
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote))))
                //生成异步任务的列表
                .collect(Collectors.toList())
                .stream()
                //阻塞获取每一个任务的结果
                .map(CompletableFuture::join)
                //生成list
                .collect(Collectors.toList());

        System.out.println(JSONUtil.toJsonStr(productList));
        System.out.println("查询结束，总耗时:" + (System.currentTimeMillis() - begin) + "ms");


    }

    /**
     * 使用并行流
     *
     * @param args
     */
    public static void main2(String[] args) {
        String product = "AJ basketball shoes";

        long begin = System.currentTimeMillis();

        List<String> productList = SHOPS.parallelStream()
                //到每一个商店获取价格，返回商品名:价格:折扣代码 给下一个流，该方法有随机耗时
                .map(shop -> shop.getPrice(product))
                //生成商品信息对象
                .map(Quote::parse)
                //计算折扣，该方法会有随机耗时
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());

        System.out.println(JSONUtil.toJsonStr(productList));
        System.out.println("查询结束，总耗时:" + (System.currentTimeMillis() - begin) + "ms");


    }


    /**
     * 使用顺序流
     *
     * @param args
     */
    public static void main1(String[] args) {

        String product = "AJ basketball shoes";

        long begin = System.currentTimeMillis();
        List<String> productList = SHOPS.stream()
                //到每一个商店获取价格，返回商品名:价格:折扣代码 给下一个流，该方法有随机耗时
                .map(shop -> shop.getPrice(product))
                //生成商品信息对象
                .map(Quote::parse)
                //计算折扣，该方法会有随机耗时
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());

        System.out.println(JSONUtil.toJsonStr(productList));
        System.out.println("查询结束，总耗时:" + (System.currentTimeMillis() - begin) + "ms");

    }
}
