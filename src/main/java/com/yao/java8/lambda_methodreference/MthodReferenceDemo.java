package com.yaoxuguang.springbootjavawebtechnologyinsider.java8.lambda_methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * java8方法引用的概念
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/7/31 09:52
 */
public class MthodReferenceDemo {

    static class Apple{
        public Apple() {
        }

        public Apple(String name) {
            this.name = name;
        }

        public Apple(String name, double weight) {
            this.name = name;
            this.weight = weight;
        }

        private String name;
        private double weight;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "name='" + name + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
    public static void main(String[] args) {
       /* Consumer<Apple> appleConsumer1 = (Apple a) -> System.out.println(a.toString());
        appleConsumer1.accept(new Apple());*/
        /*Consumer<Apple> appleConsumer = (Apple a) -> a.toString();
        Consumer<Apple> nameConsumer = (Apple a) -> a.getName();*/
        //方法引用的形式
        Consumer<Apple> appleConsumer = Object::toString;
        Consumer<Apple> nameConsumer = Apple::getName;

        /*List<String> str = Arrays.asList("a","b","c");
        str.sort((s1,s2) -> s1.compareToIgnoreCase(s2));*/
        //方法引用的方式
        List<String> str = Arrays.asList("a","b","c");
        str.sort(String::compareToIgnoreCase);

        //无参构造函数的方法引用
        Supplier<Apple> appleSupplier = Apple::new;
        Apple apple = appleSupplier.get();
        System.out.println(apple.toString());
        //有参构造函数的方法引用(一个参数)
        Function<String,Apple> appleFunction = Apple::new;
        Apple apple1 = appleFunction.apply("测试构造方法的方法引用");
        System.out.println(apple1.toString());
        //有参构造函数的方法引用（两个参数）
        BiFunction<String,Double,Apple> appleBiFunction = Apple::new;
        Apple apple2 = appleBiFunction.apply("测试两个参数的构造函数的方法引用", 16.82);
        System.out.println(apple2.toString());
    }
}
