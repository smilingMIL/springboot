package com.boot;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;


@DisplayName("Junit5功能测试类")
public class Junit5Test {


    /**
     * 为测试类或者测试方法设置展示名称
     */
    @DisplayName("测试DisplayName注解")
    @Test
    void testDisplayName(){
        System.out.println("1");
    }

    @DisplayName("测试方法二")
    @Test
    void test2(){
        System.out.println("2");
    }


    /**
     * @Disabled : 表示测试类或测试方法不执行
     */
    @Disabled
    @DisplayName("测试方法三")
    @Test
    void test3(){
        System.out.println("3");
    }


    /**
     * 表示方法可重复执行
     */
    @RepeatedTest(5)
    @Test
    void test4(){
        System.out.println(4);
    }

    /**
     * 表示在每个单元测试之前执行
     */
    @BeforeEach
    void testBeforeEach(){
        System.out.println("测试就要开始了");
    }


    /**
     *表示在每个单元测试之后执行
     */
    @AfterEach
    void testAfterEach(){
        System.out.println("测试结束了");
    }


    /**
     * 表示在所有单元测试之前执行
     */
    @BeforeAll
    static void testBeforeAll(){
        System.out.println("所有测试就要开始了");
    }


    /**
     * 表示在所有单元测试之后执行
     */
    @AfterAll
    static void testAfterAll(){
        System.out.println("所有测试已经结束了");
    }


    /**
     *表示测试方法运行如果超过了指定时间将会返回错误
     * 固定方法超时时间，超时测试就会出异常
     */
    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeout() throws InterruptedException {
        Thread.sleep(600);
        System.out.println("xxxxxxxxx");
    }


}
