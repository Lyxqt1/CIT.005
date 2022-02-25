package com.canada;
public class Package {
    String sName, sAddress, sCity, sState, sZip, rName, rAddress, rCity, rState, rZip;
    static double weight;
    double pWeight ,finalCost;
    private static double costP;
    //constructors
    public Package(String sName, String sAddress, String sCity, String sState, String sZip,
                   String rName, String rAddress, String rCity, String rState, String rZip,
                   double weightPack, double costP){
        this.sName = sName; this.sAddress = sAddress; this.sCity = sCity; this.sState = sState; this.sZip = sZip;
        this.rName = rName; this.rAddress = rAddress; this.rCity = rCity; this.rState = rState; this.rZip = rZip;
        weight = weightPack; Package.costP = costP;
        finalCost = totalCalcCost(); pWeight=weight;
    }
    public static double totalCalcCost(){
        return costP*weight;
    }

    public String toString(){
        return "PACKAGE "+GuiPackage.pCount+"\nSENDER\nName: " + sName + "\nAddress: " + sAddress + "\nCity: " + sCity +"\nState: " + sState
                + "\nZipcode: " + sZip +"\nRECIPIENT\nName: " + rName+"\nAddress: " + rAddress+"\nCity: " + rCity
                +"\nState: " + rState+"\nZipcode: " + rZip+"\nShipping type: Standard shipping      Shipping cost: " + finalCost +" PHP\n\n\n";
    }
}








