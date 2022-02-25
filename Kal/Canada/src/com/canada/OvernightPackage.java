package com.canada;

public class OvernightPackage extends Package{
    String sName, sAddress, sCity, sState, sZip, rName, rAddress, rCity, rState, rZip;
    private static double packWeight;
    private static double packCost;
    double weightPack, finalCost;
    private static double addFee;
    public OvernightPackage(String sName, String sAddress, String sCity, String sState, String sZip,
                            String rName, String rAddress, String rCity, String rState, String rZip,
                            double weightPack, double costP, double addFee) {
        super(sName, sAddress, sCity, sState, sZip, rName, rAddress, rCity, rState, rZip, weightPack, costP);
        this.sName = sName; this.sAddress = sAddress; this.sCity = sCity; this.sState = sState; this.sZip = sZip;
        this.rName = rName; this.rAddress = rAddress; this.rCity = rCity; this.rState = rState; this.rZip = rZip;
        packCost = costP; packWeight = weightPack; OvernightPackage.addFee = addFee; finalCost = totalCalcCost();
    }
    public static double totalCalcCost(){
        return (packCost+addFee)*packWeight;
    }
    public String toString(){
        return "PACKAGE "+GuiPackage.pCount+"\nSENDER\nName: " + sName + "\nAddress: " + sAddress + "\nCity: " + sCity +"\nState: " + sState
                + "\nZipcode: " + sZip +"\nRECIPIENT\nName: " + rName+"\nAddress: " + rAddress+"\nCity: " + rCity
                +"\nState: " + rState+"\nZipcode: " + rZip+"\nShipping type: overnight    Shipping cost: " + finalCost +" PHP\n\n\n";
    }
}
