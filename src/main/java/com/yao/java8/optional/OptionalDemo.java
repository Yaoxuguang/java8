package com.yaoxuguang.springbootjavawebtechnologyinsider.java8.optional;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * java8 Optional模型
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/8/12 17:08
 */
@Slf4j
public class OptionalDemo {
    private void test(String str) throws InterruptedException {
        Optional<String> optional = Optional.ofNullable(str);
        log.info(optional.orElse("qwerty"));
        log.info(optional.orElseGet(() -> "默认值"));
    }

    public static void main(String[] args) throws InterruptedException {
        OptionalDemo demo = new OptionalDemo();
//        demo.test("optional");
        demo.test(null);
    }
}
