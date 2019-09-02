package com.yaoxuguang.springbootjavawebtechnologyinsider.java8.asyncprogramming;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.*;

/**
 * java8 并发执行框架CompletableFuture
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/8/13 10:46
 */
@Slf4j
public class CompletableFutureDemo {
    public static void main(String[] args) {
        //同步执行 耗时：2013
      /*  Shop shop = new Shop();
        long start = System.nanoTime();
        shop.getPrice();
        shop.doSomethingElse();
        long end = System.nanoTime();
        log.info("耗时："+(end - start)/1_000_000);
*/
       //异步执行  耗时：1783
        int processors = Runtime.getRuntime().availableProcessors();
        log.info("运行时的可用线程数:"+processors);
        try {
            Shop shop = new Shop();
            long start = System.nanoTime();
            Future<Double> future = shop.getAsyncPrice("abc");
            shop.doSomethingElse();
            future.get();
            long end = System.nanoTime();
            log.info("耗时："+(end - start)/1_000_000);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
    static class Shop{
        void getPrice(){
           log.info("获取商品价格...");
           calculatePrice("abc");
        }

        private double calculatePrice(String product){
            delay();
            log.info("同步计算商品价格...");
            return new Random().nextDouble()*product.charAt(0)+product.charAt(1);
        }

        private Future<Double> getAsyncPrice(String product) {
            log.info("异步计算商品价格...");
            CompletableFuture<Double> future = new CompletableFuture<>();
            ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
                    0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>(1024), new ThreadPoolExecutor.AbortPolicy());
            singleThreadPool.execute(() -> {
                double price = calculatePrice(product);
                future.complete(price);
            });
            singleThreadPool.shutdown();
            return future;
        }

        private void doSomethingElse(){
            delay();
        }

        //模拟阻塞，延迟1秒
        void delay(){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
