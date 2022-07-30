package com.kal;

public class Person {
    String name;
    String address;
    String city;
    String state;
    int zipcode;

    public Person(String name, String address, String city, String state, int zipcode){
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
    public String toString(){
        return name + address + city + state + zipcode;
    }
}
