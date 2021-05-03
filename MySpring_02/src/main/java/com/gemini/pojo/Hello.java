package com.gemini.pojo;

/**
 * @author gemini
 * Created in  2021/5/3 20:14
 */
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
