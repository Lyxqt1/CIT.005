package com.kal;

import java.util.Scanner;

public class Main {
    private static int numRegion;
    private static int numTime;
    private static double numDuration;
    private static int costRate;
    private static int timePerCost;

    public static void inputRegion() {
        System.out.println("Choose your region\n  1. American region \n  2. Asian region \n  3. African region \n  4. European region");
        Scanner scanner = new Scanner(System.in);
        numRegion = scanner.nextInt();
        if (numRegion < 0 || numRegion > 4) {
            System.out.println("re-enter a valid value.");
            inputRegion();
        }
    }

    public static void inputTime() {
        System.out.println("enter time\n  1. Day time\n  2. Night time");
        Scanner scanner = new Scanner(System.in);
        numTime = scanner.nextInt();
        if (numTime < 0 || numTime > 2) {
            System.out.println("re-enter a valid value");
            inputTime();
        }
    }

    public static void inputDuration() {
        System.out.println("enter the call duration");
        Scanner scanner = new Scanner(System.in);
        numDuration = scanner.nextDouble();
        if (numDuration < 0) {
            System.out.println("re-enter a valid value");
            inputDuration();
        }
    }
    public static void switchRates() {
        switch (numRegion) {
            case 1:
                switch (numTime) {
                    case 1:
                        timePerCost = 3;
                        costRate = 50;
                        System.out.println("American region Day time call rates: 50 pesos every 3 minutes");
                        System.out.println("duration: " + numDuration+" minute(s)");
                        costCalc();
                        break;
                    case 2:
                        timePerCost = 3;
                        costRate = 45;
                        System.out.println("American region Night time call rates: 45 pesos every 3 minutes");
                        System.out.println("duration: " + numDuration+" minute(s)");
                        costCalc();
                        break;
                }
                break;
            case 2:
                switch (numTime) {
                    case 1:
                        timePerCost = 2;
                        costRate = 30;
                        System.out.println("Asian region Day time call rates: 30 pesos every 2 minutes");
                        System.out.println("duration: " + numDuration+" minute(s)");
                        costCalc();
                        break;
                    case 2:
                        timePerCost = 2;
                        costRate = 27;
                        System.out.println("Asian region Night time call rates: 27 pesos every 2 minutes");
                        System.out.println("duration: " + numDuration+" minute(s)");
                        costCalc();
                        break;
                }
                break;
            case 3:
                switch (numTime) {
                    case 1:
                        timePerCost = 3;
                        costRate = 40;
                        System.out.println("African region Day time call rates: 40 pesos every 3 minutes");
                        System.out.println("duration: " + numDuration+" minute(s)");
                        costCalc();
                        break;
                    case 2:
                        timePerCost = 3;
                        costRate = 36;
                        System.out.println("African region Night time call rates: 36 pesos every 3 minutes");
                        System.out.println("duration: " + numDuration+" minute(s)");
                        costCalc();
                        break;
                }
                break;
            case 4:
                switch (numTime) {
                    case 1:
                        timePerCost = 2;
                        costRate = 35;
                        System.out.println("European region Day time call rates: 35 pesos every 2 minutes");
                        System.out.println("duration: " + numDuration+" minute(s)");
                        costCalc();
                        break;
                    case 2:
                        timePerCost = 2;
                        costRate = 30;
                        System.out.println("European region Night time call rates: 30 pesos every 2 minutes");
                        System.out.println("duration: " + numDuration+" minute(s)");
                        costCalc();
                        break;
                }
                break;
        }
    }
    public static void costCalc(){
        double totalCost;
        if(numDuration > 0)
            totalCost = ((Math.ceil(numDuration/timePerCost) * timePerCost)*costRate)/timePerCost;
        else
            totalCost = costRate;
        System.out.print("total charge: "+ totalCost);
    }
    public static void main(String[] args) {
        inputRegion();
        inputTime();
        inputDuration();
        switchRates();
    }
}
//testing commit