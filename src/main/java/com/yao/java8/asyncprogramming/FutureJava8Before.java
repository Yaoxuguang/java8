package com.yaoxuguang.springbootjavawebtechnologyinsider.java8.asyncprogramming;

import java.util.concurrent.*;

/**
 * java8之前 Future接口的使用
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/8/13 10:26
 */
public class FutureJava8Before {
    private static Double doSomethingComputation(){
        System.out.println("耗时的操作...");
        return 0.00;
    }
    private static void doSomethingElse(){
        System.out.println("其他操作...");
    }

    public static void main(String[] args) {
        //通过executorService可以向线程池提交任务
        ExecutorService executorService = Executors.newCachedThreadPool();
        //执行耗时的操作
        Future<Double> future = executorService.submit(FutureJava8Before::doSomethingComputation);
        //异步操作进行的同时，执行其他操作
        doSomethingElse();
        try {
            //获取异步操作的结果，如果最终被阻塞，无法得到结果，那么最多等待1秒之后退出
            future.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
