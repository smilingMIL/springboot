package com.boot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 3、断言（assertions）
 * 断言（assertions）是测试方法中的核心部分，用来对测试需要满足的条件进行验证。这些断言方法都是 org.junit.jupiter.api.Assertions 的静态方法。JUnit 5 内置的断言可以分成如下几个类别：
 * 检查业务逻辑返回的数据是否合理。
 * 所有的测试运行结束以后，会有一个详细的测试报告；
 */
public class assertions {

    /**
     * 断言：前面断言失败，后面的代码都不会执行
     * //前面是期望的，后面是真实的
     */
    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertions(){
        int cal = cal(1, 1);
        //判断两个对象或两个原始类型是否相等
        assertEquals(2,cal,"业务逻辑计算失败");//传入一个字符串，如果不相等就输出字符串

        //判断两个对象引用是否指向不同的对象
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertSame(obj1,obj2,"两个对象不一样");
    }

    int cal(int i,int j){
        return i + j;
    }


    @Test
    @DisplayName("数组断言")
    public void array() {
        //通过 assertArrayEquals 方法来判断两个对象或原始类型的数组是否相等
        assertArrayEquals(new int[]{2, 1}, new int[] {1, 2},"两个数组不相等");
    }


    @Test
    @DisplayName("组合断言")
    public void all() {
        /**
         * 只有声明的所有断言都成功才能往下走
         */
        assertAll("test",()-> assertTrue(true && true,"结果不为true"),
                                 ()-> assertEquals(1,2,"结果不是1"));

        System.out.println("-----");
    }


    @Test
    @DisplayName("异常断言")
    void testException(){
        //断点业务逻辑一定有异常，如果没异常就报错
        assertThrows(ArithmeticException.class,()->{
            int i=1/2;
        },"业务逻辑居然正常运行");
    }


    @Test
    @DisplayName("快速失败")
    void testFail(){
        //通过 fail 方法直接使得测试失败
        if(2 == 2){
            fail("测试失败");
        }
    }

}
