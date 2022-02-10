package com.kal;

public class Person {
    String name;
    String address;
    String city;
    String state;
    int zipcode;

    public Person(String pName, String pAddress, String pCity, String pState, int pZipcode){
        this.name=pName;
    }
    public String toString(){
        return name;
    }
}
