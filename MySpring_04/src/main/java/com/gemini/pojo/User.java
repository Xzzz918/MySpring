package com.gemini.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author gemini
 * Created in  2021/5/4 15:01
 */
//@Component <=> <bean id="user" class="com.gemini.pojo.USer"/>
@Component
//@Scope("prototype")
@Scope("singleton")
public class User {

    public String name;
    @Value("Gemini")
    public void setName(String name) {
        this.name = name;
    }
}
