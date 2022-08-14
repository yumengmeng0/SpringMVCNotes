# SSM整合

## 1.1 需求分析
    需求：使用SSM框架完成account表的增删改查
    步骤分析：
        1.准备数据库和表记录
        2.创建Web项目
        3.编写Mybatis在SSM环境中可以单独使用
        4.编写Spring在SSM环境中可以单独使用
        5.Spring整合Mybatis
        6.编写SpringMVC在SSM环境可以单独使用
        7.Spring整合SpringMVC
 
 ## 1.5 Spring整合Mybatis
    1.整合思想
        将Mybatis接口代理对象的创建权交给Spring管理，就可以吧dao代理对象注入到service中，此时完成Spring和Mybatis整合
    2.导入整合包mybatis-spring
    3.Spring配置文件管理Mybatis
        
    
# web.xml中 load-on-startup标签的作用
 load-on-startup标签可以设置servlet的加载优先级别和容器是否在启动时加载该servlet，如下设置：
 <load-on-startup>1</load-on-startup>
 当值为0或者大于0时，代表容器启动时加载该servlet。正数的值越小，启动时加载该servlet的优先级越高。
 如果为负数，则容器启动时不会加载该servlet，只有该servlet被选择时才会加载。

 
 ## 1.7 Spring整合SpringMVC
    1.整合思想
        让Web容器启动时自动加载Spring配置文件，Web销毁时Spring的IOC容器也销毁。
    2.Spring和Web容器整合
        ContextLoaderListener加载
        可以使用spring-web包中的ContextLoaderListener监听器，监听servletContext容器的创建和销毁，来同时创建和销毁IOC容器。

```xml
    <!--    spring与web容器整合-->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:applicationContext.xml</param-value>
    </context-param>
```

## 1.8 Spring声明式事务
### (1) Spring配置文件加入声明式事务
```xml
    <!--    配置事务管理器-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"></property>
    </bean>
    <!--    开启事务注解-->
    <tx:annotation-driven></tx:annotation-driven>
```


# Error during artifact deployment. See server log for details.
https://blog.csdn.net/wt520it/article/details/88126654