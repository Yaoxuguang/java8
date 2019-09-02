package com.yaoxuguang.springbootjavawebtechnologyinsider.java8.defaultmethod;

/**
 * java中的菱形继承问题
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/8/12 15:32
 */
public class DiamondExtend implements B,C{
    public static void main(String[] args) {
        new DiamondExtend().sayHello();
    }
}
interface A{
    default void sayHello(){
        System.out.println("From A ...");
    };
}
interface B extends A{}
interface C extends A{}


