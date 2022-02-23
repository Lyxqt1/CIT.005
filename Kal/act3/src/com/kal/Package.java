package com.kal;

public class Package {
    String senderName, senderAddress, senderCity, senderState;
    private String  senderZip;
    private String recipientName, recipientAddress, recipientCity, recipientState;
    private String  recipientZip;
    static double packWeight;
    double pWeight;
    private static double packCost;
    double totalCost;
    //constructors
    public Package(String senderName, String senderAddress, String senderCity, String senderState, String senderZip,
                   String recipientName, String recipientAddress, String recipientCity, String recipientState, String recipientZip,
                   double packageWeight, double packageCost){
        this.senderName = senderName; this.senderAddress = senderAddress; this.senderCity = senderCity; this.senderState = senderState; this.senderZip = senderZip;
        this.recipientName = recipientName; this.recipientAddress = recipientAddress; this.recipientCity = recipientCity; this.recipientState = recipientState; this.recipientZip = recipientZip;
        packWeight = packageWeight; packCost = packageCost;
        totalCost = totalCalcCost(); pWeight=packWeight;
    }
    public static double totalCalcCost(){
        return packCost*packWeight;
    }

    public String toString(){
        return "PACKAGE "+PackageGUI.packageCount+"\n----------------SENDER----------------\nName: " + senderName + "\nAddress: " + senderAddress + "\nCity: " + senderCity +"\nState: " + senderState
                + "\nZipcode: " + senderZip +"\n----------------RECIPIENT----------------\nName: " + recipientName+"\nAddress: " + recipientAddress+"\nCity: " + recipientCity
                +"\nState: " + recipientState+"\nZipcode: " + recipientZip+"\nShipping type: Standard base ------ Shipping cost: " + totalCost +" PHP\n\n";
    }
}


