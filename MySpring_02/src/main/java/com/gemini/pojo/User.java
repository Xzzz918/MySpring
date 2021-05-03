package com.gemini.pojo;

/**
 * @author gemini
 * Created in  2021/5/3 22:24
 */
public class User {
    private String name;

//    public User() {
//        System.out.println("User()");
//    }

    public User(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void show(){
        System.out.println("User: " + name);
    }
}
