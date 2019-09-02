package com.yaoxuguang.springbootjavawebtechnologyinsider.java8.functionprogrammingthoughts;

import lombok.extern.slf4j.Slf4j;

import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * java8 函数式编程技巧 高级特性
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/8/15 10:59
 */
@Slf4j
public class ProgrammingSkills {
    public static void main(String[] args) {
        //高阶函数
        Function<String, Integer> fun = highOderFunction("12"::toLowerCase);
        Integer str = fun.apply("3");
        log.info(String.valueOf(str));
        //科里化
        curriedConverter(0.65,100.00);
        //持久化数据结构
        //stream的延迟处理
        //模糊匹配
        //缓存-记忆表
        //结合器 repeat(3,(Integer x) -> 2 * x)
        Function<Integer, Integer> repeat = repeat(3, (Integer x) -> 2 * x);
        log.info(String.valueOf( repeat.apply(10)));
    }

    //自定义高阶函数
    private static Function<String,Integer> highOderFunction(Supplier<String> supplier){
        String str = supplier.get();
        return (String string)-> Integer.parseInt(str+string);
    }

    //科里化
    private static DoubleUnaryOperator curriedConverter(double f, double b){
        return (double x)-> x * f + b;
    }

    private static <A,B,C> Function<A,C> compose(Function<B,C> g, Function<A,B> f){
        return x -> g.apply(f.apply(x));
    }
    private static <A> Function<A,A> repeat(int n,Function<A,A> function){
        return n == 0 ? x -> x : compose(function,repeat(n - 1,function));
    }
}
