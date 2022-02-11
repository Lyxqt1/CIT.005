package com.kal;

public class Package {
    private String senderName, senderAddress, senderCity, senderState;
    private int senderZip;
    private String recipientName, recipientAddress, recipientCity, recipientState;
    private int recipientZip;
    float packageWeight;
    double packageCost;
    int packageType;
    public Package(String senderName, String senderAddress, String senderCity, String senderState, int senderZip,
                   String recipientName, String recipientAddress, String recipientCity, String recipientState, int recipientZip,
                   float packageWeight, double packageCost, int packageType){
        this.senderName = senderName; this.senderAddress = senderAddress; this.senderCity = senderCity; this.senderState = senderState; this.senderZip = senderZip;
        this.recipientName = recipientName; this.recipientAddress = recipientAddress; this.recipientCity = recipientCity; this.recipientState = recipientState; this.recipientZip = recipientZip;
        this.packageWeight = packageWeight; this.packageCost = packageCost; this.packageType = packageType;
    }
    double calculateCost(float packageWeight,double packageCost) //function that calculate the cost z
    {
        double z;  //total cost = weight*cost per ounce
        z = packageWeight * packageCost;  //the cost z
        System.out.println("The Base Cost = " +z);
        return z;
    }

    @Override
    public String toString() {
        return senderName+senderAddress+senderCity;
    }
}


