package com.yaoxuguang.springbootjavawebtechnologyinsider.java8.defaultmethod;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * java8默认方法示例接口
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/8/12 11:55
 */
@FunctionalInterface
public interface DefalutInterface<T> {
    T apply(T t);

    default void doAction(){
        System.out.println("java8默认方法1");
    }

    static void doStatic(){
        System.out.println("java8静态方法1");
    }

    class Test implements DefalutInterface<String>{

        @Override
        public String apply(String s) {
            doAction();
            doStatic();
            return "处理成功:"+s;
        }

        public static void main(String[] args) {
            Test test = new Test();
            test.apply("java8");
        }
    }

    class Test1 implements DefalutInterface<Integer>{
        @Override
        public void doAction() {
            System.out.println("子类覆盖了接口的方法");
        }

        @Override
        public Integer apply(Integer integer) {
            doAction();
            doStatic();
            return Objects.isNull(integer) ? 0:integer;
        }

        public static void main(String[] args) {
            Test1 test1 = new Test1();
            test1.apply(null);
        }
    }

    class Test3 implements DefalutInterface<String>,DefalutInterface2<String,Integer>{

        @Override
        public String apply(String s) {
            return s;
        }

       /* @Override
        public void doAction() {
            System.out.println("如果实现的方法签名相同，重写接口方法");
        }*/

       @Override
        public void doAction(){
            DefalutInterface.super.doAction();
           System.out.println("显示调用指定接口的方法");
        }

        @Override
        public Integer test(String s) {
            return Integer.parseInt(s);
        }
    }
}

