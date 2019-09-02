package com.yaoxuguang.springbootjavawebtechnologyinsider.java8.FrokJoin;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.RecursiveTask;

/**
 * java 分支/合并框架 求和案例
 *
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/8/7 12:00
 */
@Slf4j
public class FrokJoinSumCalculator extends RecursiveTask<Long> {
    /**
     * 要求和的数组
     */
    private final long[] numbers;
    /**
     *子任务处理的起始位置
     */
    private final int start;
    /**
     * 子任务处理的终止位置
     */
    private final int end;

    public static final long THRESHOLD = 10_000;

    public FrokJoinSumCalculator(long[] numbers) {
        this(numbers,0,numbers.length);
    }

    public FrokJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        //小于阈值，顺序计算
        if(length < THRESHOLD){
            return computeSequentially();
        }
        //大于阈值，并行计算
        //构建左侧计算任务
        FrokJoinSumCalculator leftTask = new FrokJoinSumCalculator(numbers,start,start+length/2);
        //用另一个ForkJoinPool线程异常执行子任务
        leftTask.fork();
        //构建右侧计算任务
        FrokJoinSumCalculator rightTask = new FrokJoinSumCalculator(numbers,start+length/2,end);
        //同步执行第二个子任务
        Long rightResult = rightTask.compute();
        //等待第一个子任务的执行结果
        Long leftResult = leftTask.join();
        //返回两个子执行的结果
        return rightResult + leftResult;
    }

    /**
     * 顺序计算
     * @return long
     */
    private long computeSequentially(){
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
