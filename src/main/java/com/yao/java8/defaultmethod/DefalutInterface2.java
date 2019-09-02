package com.yaoxuguang.springbootjavawebtechnologyinsider.java8.defaultmethod;

/**
 * java8 接口默认方法2
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/8/12 14:49
 */
@FunctionalInterface
public interface DefalutInterface2<T,R> {
    R test(T t);

    default void doAction(){
        System.out.println("java8默认方法2");
    }
}
