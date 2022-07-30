package com.canada;

public class Person {
    String Name;
    String Address;
    String City;
    String State;
    String Zip;

    public Person(String name, String address, String city, String state, String zip){
        this.Name = name;
        this.Address = address;
        this.City = city;
        this.State = state;
        this.Zip = zip;
    }
    public String toString(){
        return Name + Address + City + State + Zip;
    }
}
