package com.Lei;

public class Person{
    String Name;
    String Address;
    String City;
    String State;
    String ZIP;


    public Person(String Name, String Address, String City, String State, String ZIP){
        this.Name = Name;
        this.Address = Address;
        this.City = City;
        this. State = State;
        this.ZIP = ZIP;
    }
    public String toString(){
        return Name + Address + City + State + ZIP;
    }



}