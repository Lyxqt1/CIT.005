//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kal;

import java.util.Scanner;

public class Main {
    private static int numRegion;
    private static int numTime;
    private static double numDuration;
    private static double totalCost;
    private static int costRate;
    private static int timePerCost;

    public Main() {
    }

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
        if (numDuration < 0.0D) {
            System.out.println("re-enter a valid value");
            inputDuration();
        }

    }

    public static void switchRates() {
        switch(numRegion) {
            case 1:
                switch(numTime) {
                    case 1:
                        timePerCost = 3;
                        costRate = 50;
                        System.out.println("American region Day time call rates: 50 pesos every 3 minutes");
                        System.out.println("duration: " + numDuration + " minute(s)");
                        costCalc();
                        break;
                    case 2:
                        timePerCost = 3;
                        costRate = 45;
                        System.out.println("American region Night time call rates: 45 pesos every 3 minutes");
                        System.out.println("duration: " + numDuration + " minute(s)");
                        if (numDuration > 0.0D) {
                            totalCost = Math.ceil(numDuration / (double)timePerCost) * (double)timePerCost * (double)costRate / (double)timePerCost;
                        } else {
                            totalCost = (double)costRate;
                        }

                        System.out.print(totalCost);
                }
            case 2:
            default:
        }
    }

    public static void costCalc() {
        if (numDuration > 0.0D) {
            totalCost = Math.ceil(numDuration / (double)timePerCost) * (double)timePerCost * (double)costRate / (double)timePerCost;
        } else {
            totalCost = (double)costRate;
        }

        System.out.print(totalCost);
    }

    public static void main(String[] args) {
        inputRegion();
        inputTime();
        inputDuration();
        switchRates();
    }
}
