package com.gemini.pojo;

/**
 * @author gemini
 * Created in  2021/5/4 10:56
 */
public class Address {
    private String address;

    public Address() {
    }

    public Address(String address) {
        this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }
}
