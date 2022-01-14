package com.kal;

import java.util.Scanner;

public class Main {
    private static int numRegion;
    private static int numTime;
    private static int numDuration;

    public static void inputRegion(){
        System.out.println("Choose your region\n  1. American region \n  2. Asian region \n  3. African region \n  4. European region");
        Scanner scanner = new Scanner(System.in);
        numRegion = scanner.nextInt();

        if(numRegion<0||numRegion>4){
            System.out.println("re-enter a valid value.");
            inputRegion();
        }
    }
    public static void inputTime(){
        System.out.println("enter time\n  1. Day time\n  2. Night time");
        Scanner scanner = new Scanner(System.in);
        numTime = scanner.nextInt();
        if(numTime<0||numTime>1){
            System.out.println("re-enter a valid value");
            inputTime();
        }
    }
    public static void inputDuration(){
        System.out.println("enter the call duration");
        Scanner scanner = new Scanner(System.in);
        numDuration = scanner.nextInt();
        if(numDuration<0){
            System.out.println("re-enter a valid value");
            inputDuration();
        }

    }
    public static void main(String[] args) {
        inputRegion();
        inputTime();
        inputDuration();
        System.out.println(numDuration);
        System.out.println(numRegion);
        System.out.println(numTime);
    }
}
