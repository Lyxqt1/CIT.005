package com.kal;

import static com.kal.Main.totalCostVec;

public class TestingPack {
    public static double packageCost = 69D;
    public static int packageType = 0;
    static double packageWeight;
    public static String senderName;
    public static String senderAddress;
    public static String senderCity;
    public static String senderState;
    public static int senderZipcode;
    public static String recipientName;
    public static String recipientAddress;
    public static String recipientCity;
    public static String recipientState;
    public static int recipientZipcode;
    public static double totalCost;
    public static void main(String[] args) {
        PackageGUI yes = new PackageGUI();
        PackageGUI.mainWindow();
    }
}
