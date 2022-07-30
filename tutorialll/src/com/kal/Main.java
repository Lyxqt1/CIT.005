package com.kal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double packageCost = 69.420d;
        System.out.println("enter the details below\n----------------SENDER----------------");
        String senderName = inputName(); //all of these input prints the data needed then asks the user for an input corresponding to that then returns it.
        String senderAddress = inputAddress();
        String senderCity = inputCity();
        String senderState = inputState();
        int senderZipcode = inputZipcode();
        System.out.println("\n----------------RECIPIENT----------------");
        String recipientName = inputName();
        String recipientAddress = inputAddress();
        String recipientCity = inputCity();
        String recipientState = inputState();
        int recipientZipcode = inputZipcode();
        System.out.println("----------------Package details----------------");
        double packageWeight = inputPackageWeight();
        int packageType = inputPackageType();//packagetype determines the switch case. end of inputs

        Person sender = new Person(senderName, senderAddress, senderCity, senderState, senderZipcode);
        Person recipient = new Person(recipientName, recipientAddress, recipientCity, recipientState, recipientZipcode);
        System.out.println(sender.name);

        Package packs= new Package(sender.name, sender.address, sender.city, sender.state, sender.zipcode,
                recipient.name, recipient.address, recipient.city, recipient.state, recipient.zipcode,
                packageWeight, packageCost);



    }
    //all of these input prints the data needed then asks the user for an input corresponding to that then returns it.
    static String inputName(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Name: ");
        String name;
        name = sc.nextLine();
        return name;
    }
    static String inputAddress(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Address: ");
        return sc.nextLine();
    }
    static String inputCity(){
        Scanner sc = new Scanner(System.in);
        System.out.print("City: ");
        String city = sc.nextLine();
        return city;
    }
    static String inputState(){
        Scanner sc = new Scanner(System.in);
        System.out.print("State: ");
        String state = sc.nextLine();
        return state;
    }
    static int inputZipcode(){
        int zipcode;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("Zipcode:");
            zipcode = sc.nextInt();
            if((zipcode<=0)){
                System.out.println("re-enter a valid Zipcode - integer");
            }
        }while(zipcode<=0);
        sc.nextLine();
        return zipcode;
    }
    static int inputPackageType(){
        int packageType;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("select your shipping option:\n1. standard\n2. two-day delivery\n3. overnight delivery");
            packageType = sc.nextInt();
            if(!(packageType>=1&&packageType<=3)){
                System.out.println("re-enter a valid package type");
            }
        }while(!(packageType>=1&&packageType<=3));
        sc.nextLine();
        return packageType;
    }
    static double inputPackageWeight(){
        double packageWeight;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("enter the package weight(ounces)");
            packageWeight = sc.nextDouble();
            if((packageWeight<=0)){
                System.out.println("re-enter a valid package weight");
            }
        }while(packageWeight<=0);
        sc.nextLine();
        return packageWeight;
    }

}
