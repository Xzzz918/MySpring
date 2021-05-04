package com.gemini.config;

import com.gemini.pojo.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author gemini
 * Created in  2021/5/4 15:23
 */
//代表这是一个配置类
@Configuration
@ComponentScan("com.gemini.pojo")
//@Import(MyConfig2.class)
public class MyConfig {
//    方法名相当于bean的id，返回值相当于bean的class
    @Bean
    public Dog getDog(){
        return new Dog();
    }
}
