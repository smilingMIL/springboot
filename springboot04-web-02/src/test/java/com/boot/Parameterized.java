package com.boot;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

/**
 * 参数化测试是JUnit5很重要的一个新特性，它使得用不同的参数多次运行测试成为了可能，也为我们的单元测试带来许多便利。

 * 利用**@ValueSource**等注解，指定入参，我们将可以使用不同的参数进行多次单元测试，
而不需要每新增一个参数就新增一个单元测试，省去了很多冗余代码。

 * **@ValueSource**: 为参数化测试指定入参来源，支持八大基础类以及String类型,Class类型
 *
 * **@NullSource**: 表示为参数化测试提供一个null的入参
 *
 * **@EnumSource**: 表示为参数化测试提供一个枚举入参
 *
 * **@CsvFileSource**：表示读取指定CSV文件内容作为参数化测试入参
 *
 * **@MethodSource**：表示读取指定方法的返回值作为参数化测试入参(注意方法返回需要是一个流)
 */

@DisplayName("参数化测试")
public class Parameterized {


    @ParameterizedTest  //标识为一个参数化测试
    @ValueSource(ints = {1,2,3,4,5})
    void testParameterized(int i){
        System.out.println(i);
    }


    //表示读取指定方法的返回值作为参数化测试入参(注意方法返回需要是一个流)
    @ParameterizedTest  //标识为一个参数化测试
    @MethodSource("StringProvider")
    void testParameterized2(String i){
        System.out.println(i);
    }

    static Stream<String> StringProvider(){
        return Stream.of("apple","banana","atguigu");
    }

}
