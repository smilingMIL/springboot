package com.boot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;


/**
 * JUnit 5 可以通过 Java 中的内部类和@Nested 注解实现嵌套测试，
 * 从而可以更好的把相关的测试方法组织在一起。在内部类中可以使用@BeforeEach 和@AfterEach 注解，
 * 而且嵌套的层次没有限制。
 */
@DisplayName("嵌套测试")
public class TestingAStackDemo {

    Stack<Object> stack;

    @Test
    @DisplayName("new Stack()")
    void isInstantiatedWithNew() {
        new Stack<>();
        //嵌套测试情况下，外层的Test不能驱动内层的Before(After)Each/All之类的方法提前/之后运行
        assertNull(stack);
    }

            @Nested
            @DisplayName("when new")
            class WhenNew {

                @BeforeEach
                void createNewStack() {
                    stack = new Stack<>();
                }

                @Test
                @DisplayName("is empty")
                void isEmpty() {
                    //判断栈里面的元素是空的
                    assertTrue(stack.isEmpty());
                }

                @Test
                @DisplayName("throws EmptyStackException when popped")
                void throwsExceptionWhenPopped() {
                    //断定一定会抛出异常，因为栈里面没有元素，
                    assertThrows(EmptyStackException.class, stack::pop);
                }

                @Test
                @DisplayName("throws EmptyStackException when peeked")
                void throwsExceptionWhenPeeked() {
                    assertThrows(EmptyStackException.class, stack::peek);
                }

                            @Nested
                            @DisplayName("after pushing an element")
                            class AfterPushing {

                                String anElement = "an element";

                                @BeforeEach
                                void pushAnElement() {
                                    stack.push(anElement);
                                }

                                /**
                                 * 内层的Test可以驱动外层的Before(After)Each/All之类的方法提前/之后运行
                                 */
                                @Test
                                @DisplayName("it is no longer empty")
                                void isNotEmpty() {
                                    //判断栈里面不为空
                                    assertFalse(stack.isEmpty());
                                }

                                @Test
                                @DisplayName("returns the element when popped and is empty")
                                void returnElementWhenPopped() {
                                    assertEquals(anElement, stack.pop());
                                    assertTrue(stack.isEmpty());
                                }

                                @Test
                                @DisplayName("returns the element when peeked but remains not empty")
                                void returnElementWhenPeeked() {
                                    assertEquals(anElement, stack.peek());
                                    assertFalse(stack.isEmpty());
                                }
                            }
            }
}
