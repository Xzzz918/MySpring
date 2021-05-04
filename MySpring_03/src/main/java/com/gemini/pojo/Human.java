package com.gemini.pojo;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author gemini
 * Created in  2021/5/4 13:50
 */
public class Human {
    @Autowired
    private Dog dog;
    @Autowired
    private Cat cat;
    private String name;

    public Dog getDog() {
        return dog;
    }

    public Cat getCat() {
        return cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human{" +
                "dog=" + dog +
                ", cat=" + cat +
                ", name='" + name + '\'' +
                '}';
    }
}
