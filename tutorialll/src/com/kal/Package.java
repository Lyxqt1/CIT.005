package com.kal;

public class Package {
    String senderName, senderAddress, senderCity, senderState;
    private int senderZip;
    private String recipientName, recipientAddress, recipientCity, recipientState;
    private int recipientZip;
    private static double packWeight;
    private static double packCost;
    double totalCost;
    //constructors
    public Package(String senderName, String senderAddress, String senderCity, String senderState, int senderZip,
                   String recipientName, String recipientAddress, String recipientCity, String recipientState, int recipientZip,
                   double packageWeight, double packageCost){
        this.senderName = senderName; this.senderAddress = senderAddress; this.senderCity = senderCity; this.senderState = senderState; this.senderZip = senderZip;
        this.recipientName = recipientName; this.recipientAddress = recipientAddress; this.recipientCity = recipientCity; this.recipientState = recipientState; this.recipientZip = recipientZip;


        packWeight = packageWeight; packCost = packageCost;
        totalCost = totalCalcCost();
    }
    public static double totalCalcCost(){
        return packCost*packWeight;
    }
}
