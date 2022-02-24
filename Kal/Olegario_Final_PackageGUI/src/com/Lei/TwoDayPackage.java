package com.Lei;

public class TwoDayPackage extends Package{
    String SenderName, SenderAddress, SenderCity, SenderState, SenderZIP;
    private String ReceiverName, ReceiverAddress, ReceiverCity, ReceiverState, ReceiverZIP;
    private static double packweight;
    private static double packcost;
    double totalcost;
    private static double flatFee;
    public TwoDayPackage(String SenderName, String SenderAddress, String SenderCity, String SenderState, String SenderZIP,
                         String ReceiverName, String ReceiverAddress, String ReceiverCity, String ReceiverState, String ReceiverZIP,
                         double PackageWeight, double packagecost, double flatFee){
        super(SenderName, SenderAddress, SenderCity, SenderState, SenderZIP, ReceiverName, ReceiverAddress, ReceiverCity, ReceiverState, ReceiverZIP, PackageWeight, packagecost);
        this.SenderName = SenderName;
        this.SenderAddress = SenderAddress;
        this.SenderCity = SenderCity;
        this.SenderState = SenderState;
        this.SenderZIP = SenderZIP;
        this.ReceiverName = ReceiverName;
        this.ReceiverAddress = ReceiverAddress;
        this.ReceiverCity = ReceiverCity;
        this.ReceiverState = ReceiverState;
        this.ReceiverZIP = ReceiverZIP;
        packweight =  PackageWeight;
        packcost = packagecost;
        TwoDayPackage.flatFee = flatFee;
        totalcost = totalcalcCost();

    }
    public static double totalcalcCost(){
        return packcost * packweight + flatFee;
    }

    public String toString(){
        System.out.println("Sender: \n");
        System.out.println("Name: "+ SenderName);
        System.out.println("Address: "+SenderAddress);
        System.out.println("City: "+SenderCity);
        System.out.println("State: "+SenderState);
        System.out.println("ZIPcode: "+SenderZIP+ "\n");

        System.out.println("Receiver: \n");
        System.out.println("Name: "+ReceiverName);
        System.out.println("Address: "+ReceiverAddress);
        System.out.println("City: "+ReceiverCity);
        System.out.println("State: "+ReceiverState);
        System.out.println("ZIPcode: "+ReceiverZIP);
        System.out.println("Shipping type: Two Day \n Shipping cost: " +totalcost+ "PHP");
        return "PACKAGE "+MainGUI.packsCount+"\nSENDER\nName: " + SenderName + "\nAddress: " + SenderAddress + "\nCity: " + SenderCity +"\nState: " + SenderState
                + "\nZipcode: " + SenderZIP +"\nRECIPIENT\nName: " + ReceiverName+"\nAddress: " + ReceiverAddress+"\nCity: " + ReceiverCity
                +"\nState: " + ReceiverState+"\nZipcode: " + ReceiverZIP+"\nShipping type: Two Day ------ Shipping cost: " + totalcost +" PHP";

    }

}