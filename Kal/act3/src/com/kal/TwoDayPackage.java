package com.kal;

public class TwoDayPackage extends Package{
    String senderName, senderAddress, senderCity, senderState;
    private String senderZip;
    private String recipientName, recipientAddress, recipientCity, recipientState;
    private String recipientZip;
    private static double packWeight;
    private static double packCost;
    double pWeight;
    private static double flatFee;
    double totalCost;
    public TwoDayPackage(String senderName, String senderAddress, String senderCity, String senderState, String senderZip, String recipientName, String recipientAddress, String recipientCity, String recipientState, String recipientZip, double packageWeight, double packageCost, double flatFee) {
        super(senderName, senderAddress, senderCity, senderState, senderZip, recipientName, recipientAddress, recipientCity, recipientState, recipientZip, packageWeight, packageCost);
        this.senderName = senderName; this.senderAddress = senderAddress; this.senderCity = senderCity; this.senderState = senderState; this.senderZip = senderZip;
        this.recipientName = recipientName; this.recipientAddress = recipientAddress; this.recipientCity = recipientCity; this.recipientState = recipientState; this.recipientZip = recipientZip;
        packCost = packageCost; packWeight = packageWeight; TwoDayPackage.flatFee = flatFee; totalCost = totalCalcCost();
        pWeight = packageWeight;
    }
    public static double totalCalcCost(){
        return packCost*packWeight+flatFee;
    }

    public String toString(){
        System.out.println("----------------SENDER----------------\nName: " + senderName);
        System.out.println("Address: " + senderAddress);
        System.out.println("City: " + senderCity);
        System.out.println("State: " + senderState);
        System.out.println("Zipcode: " + senderZip);
        System.out.println("----------------RECIPIENT----------------\nName: " + recipientName);
        System.out.println("Address: " + recipientAddress);
        System.out.println("City: " + recipientCity);
        System.out.println("State: " + recipientState);
        System.out.println("Zipcode: " + recipientZip);
        System.out.println("\nShipping type: Two Day Shipping ------ Shipping cost: " + totalCost +" PHP");
        return "--------------------------------------------------------------";
    }
}
