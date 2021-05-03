# Spring

## Spring简介

Spring是一个**轻量**级的**非入侵式**的**控制反转(IoC)**和**面向切面(AOP)**的**支持事务的处理**的**容器框架**。

- 官网文档：https://docs.spring.io/spring-framework/docs/current/reference/html/core.html
- 官网：https://spring.io/projects/spring-framework#overview
- 官方下载地址：https://repo.spring.io/list/libs-release-local/org/springframework/spring/5.3.5/
- GitHub源码地址：https://github.com/spring-projects/spring-framework.git

- Maven依赖：

```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.3.5</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.3.5</version>
</dependency>

```

## Spring组成及拓展

### 组成

![image-20210503192040290](noteImages/image-20210503192040290.png)

### 拓展

#### 现代基于Spring的Java开发

构建——协调——连接

![image-20210503192216396](noteImages/image-20210503192216396.png)

#### Spring Boot

- 一个快速开发的脚手架。
- 可以快速开发单个微服务。
- 约定大于配置。

#### Spring Cloud

- 基于Spring Boot实现的。

## IOC理论

###  IOC原型

- UserDao接口
- UserDaoImpl实现类
- UserService业务接口
- UserServiceImpl业务实现类

在我们之前的业务中，用户的需求可能会影响我们原来的代码（每次变动都需要修改大量代码），在代码量较大的情况下修改一次的成本很大，耦合性太高。

我们使用了一个set接口实现：

```java
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    //利用set进行动态实现值的注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void getUser() {
        userDao.getUser();
    }
}
```

- 之前：程序为主动创建对象，控制权在程序员手上。
- 使用了set注入后，程序不再具有主动性，而是变成了被动的接收对象。

```java
public class MyTest {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        //被动的接收UserDaoMysqlImpl对象
        userService.setUserDao(new UserDaoMysqlImpl());
        userService.getUser();
    }
}
```

这种思想，从本质上使得程序员不再去管理对象的创建了，系统的耦合性大大降低，可以更加专注于业务的实现上。

这是IOC的原型。

### IOC本质

在IOC之前，主动权在程序员，程序控制调用什么。

![image-20210503195725046](noteImages/image-20210503195725046.png)

IOC：主动权在用户手中，用户选择调用什么。

![image-20210503195814501](noteImages/image-20210503195814501.png)

**IOC是一种设计思想，它是一种通过描述（XML或注解）并通过第三方去生产或获取特定对象的方式，而DI（依赖注入）是其在Spring中的实现方式。**

![image-20210503200121712](noteImages/image-20210503200121712.png)

Spring容器在初始化时先读取配置文件，根据配置文件或元数据创建与组织对象存入容器中，程序使用时再从IOC容器中取出需要的对象。

![image-20210503200647072](noteImages/image-20210503200647072.png)

##  HelloSpring

### 实体类

```java
public class Hello {
    private String str;

    public void setStr(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }

    public void show(){
        System.out.println("Hello " + str);
    }
}
```

### XML配置文件

- 在Spring中创建对象并设置属性。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">
<!--    使用Spring来创建对象，在Spring中，这些都称为Bean
        beans = 对象的容器
        Hello hello = new Hello();
        bean = 对象   new Hello();
        id = hello（变量名）
        class = new 的对象
        property 相当于给对象中的属性设置一个值，利用的是set方法
        -->
    <bean id="hello" class="com.gemini.pojo.Hello">
<!--        ref:引用Spring容器中创建好的对象-->
<!--        value：具体的值，基本数据类型和String类型-->
        <property name="str" value="hello"/>
        <!-- collaborators and configuration for this bean go here -->
    </bean>


    <!-- more bean definitions go here -->

</beans>
```

### 测试类

```java
    @Test
    public void test() {
//        获取Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("helloBeans.xml");
//        对象现在都在Spring容器中，如果要使用，直接去容器中取出来即可
        Hello hello = (Hello) context.getBean("hello");
        hello.show();
```

### 输出

```xml
Hello hello
```

### 总结

要实现不同的操作，只需要在XML配置文件中进行修改，所谓的IOC即为：**对象由Spring来创建，管理和分配。**

## IOC创建对象的方式

1. 使用无参构造方法创建对象，默认实现。

2. 假设要使用有参构造，有以下三种方法，推荐第三种。

   1. 下标赋值

      ```xml
      <!--        有参构造创建对象方式一：下标赋值-->
          <bean id="user" class="com.gemini.pojo.User">
              <constructor-arg index="0" value="Gemini"/>
          </bean>
      ```

   2. 类型赋值（不建议使用）

      ```xml
      <!--    有参构造创建对象方式二：类型赋值(不建议使用）-->
      <bean id="user" class="com.gemini.pojo.User">
          <constructor-arg type="java.lang.String" value="Gemini"/>
      </bean>
      ```

   3. 参数名赋值

      ```xml
      <!--    有参构造创建对象方式三：通过参数名赋值-->
      <bean id="user" class="com.gemini.pojo.User">
          <constructor-arg name="name" value="Gemini"/>
      </bean>
      ```

   ### 总结

   **在配置文件加载的时候，容器中的对象就已经初始化了。**

   **容器中的对象默认为单例实现。**

## Spring配置

### 别名

```xml
<!--    别名：可以使用别名获取到该对象-->
    <alias name="user" alias="user2"/>
```

### Bean的配置

- id:bean的唯一标识符，也就是相当于对象名
- class:bean对象所对应的全限定名
- name:也是别名，而且name可以同时取多个别名，且可通过逗号/空格/分号等分割。

```xml
<bean id="user" class="com.gemini.pojo.User" name="user3,user4,user5">
    <constructor-arg name="name" value="Gemini"/>
</bean>
```

### Import  

一般用于团队开发使用，可以将多个配置文件导入合并为一个。

当项目中有多人开发时，不同的人在不同的类上开发，不同的类注册的xml的文件不尽相同，我们可以利用import将所有人的beans.xml合并为一个总的xml，使用的时候直接使用总的配置即可。

applicationContext.xml:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">
    <import resource="helloBeans.xml"/>
    <import resource="helloBeans2.xml"/>
    <import resource="helloBeans3.xml"/>

</beans>
```

