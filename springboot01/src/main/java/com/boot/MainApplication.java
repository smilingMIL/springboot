package com.boot;

import ch.qos.logback.core.db.DBHelper;
import com.boot.bean.User;
import com.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序类
 *
 * @SpringBootApplication：这是一个springBoot应用
 */

/**@SpringBootApplication的合成注解的 分解： (有3个)
 *
 * 一：@SpringBootConfiguration : @Configuration。代表当前是一个配置类
 * 二：@EnableAutoConfiguration里面合成了两个注解 ：分解：（有2个）
 *                          1.@AutoConfigurationPackage ：自动配置包？指定了默认的包规则 （里面有1个这个注解）
 *                                      1.@Import(AutoConfigurationPackages.Registrar.class)  //给容器中导入一个组件
 *                                      //利用Registrar给容器中导入一系列组件
 *                                      //将指定的一个包下的所有组件导入进来？MainApplication 所在包下。
 *                          2.@Import(AutoConfigurationImportSelector.class) ：
 *                                      1、利用getAutoConfigurationEntry(annotationMetadata);给容器中批量导入一些组件
 *                                      2、调用List<String> configurations = getCandidateConfigurations(annotationMetadata, attributes)获取到所有需要导入到容器中的配置类
 *                                      3、利用工厂加载 Map<String, List<String>> loadSpringFactories(@Nullable ClassLoader classLoader)；得到所有的组件
 *                                      4、从META-INF/spring.factories位置来加载一个文件。
 * 	                                    默认扫描我们当前系统里面所有META-INF/spring.factories位置的文件
 *                                      spring-boot-autoconfigure-2.3.4.RELEASE.jar包里面也有META-INF/spring.factories
 *
 *              虽然我们127个场景的所有自动配置启动的时候默认全部加载。xxxxAutoConfiguration
 *              按照条件装配规则（@Conditional），最终会按需配置。
 *
 * 三：@ComponentScan ：指定扫描哪些，Spring注解；
 *                (excludeFilters = { @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
 *                @Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
 *

 */

//想要改变扫描路径，@SpringBootApplication(scanBasePackages="com.xxx")
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {

        //1.返回我们IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //2.查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

/*        //3.从容器中获取组件

        User user = run.getBean("user01", User.class);
        System.out.println(user);

        //4.com.boot.config.MyConfig$$EnhancerBySpringCGLIB$$c62d0cf0@7a26928a
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法，springboot总会检查这个组件是否在容器中有,
        //如果有就不会再创建，保持组件单实例
        User user1 = bean.user01();
        User user2 = bean.user01();
        System.out.println(user1 == user2);

        //5.从容器中获取组件
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        System.out.println("========");
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        DBHelper bean1 = run.getBean(DBHelper.class);
        System.out.println(bean1);*/


        boolean b = run.containsBean("user01");
        System.out.println("容器中有没有user01这个组件：" + b);


    }
}
