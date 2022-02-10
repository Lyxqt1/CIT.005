package com.kal;

public class Package {
    private String senderName;
    public Package(String senderName, String senderAddress, String senderCity, String senderState, int senderZip,
                   String recipientName, String recipientAddress, String recipientCity, String recipientState, int Zip,
                   float packageWeight, double packageCost, int packageType){
        this.senderName = senderName;
    }
    double calculateCost(float weight,double costPerOunce) //function that calculate the cost z
    {
        double z;  //total cost = weight*cost per ounce
        z = weight * costPerOunce;  //the cost z
        System.out.println("The Base Cost = " +z);
        return z;
    }

    @Override
    public String toString() {
        return senderName;
    }
}


