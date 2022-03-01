package com.boot;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *      测试前置条件
 *
 * JUnit 5 中的前置条件（**assumptions【假设】**）类似于断言，
 * 不同之处在于**不满足的断言会使得测试方法失败**，
 *  而不满足的**前置条件只会使得测试方法的执行终止**。
 * 前置条件可以看成是测试方法执行的前提，当该前提不满足时，就没有继续执行的必要。
 */
public class assumptions {

    @DisplayName("前置条件")
    @Test
    void testAssumptions(){
        Assumptions.assumeTrue(false,"结果不是true");
        System.out.println(1111);
    }

}
