package com.kal;
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {
        float packageWeight = 0;
        int packageType = 0;
        double packageCost = 0;


        System.out.println("enter the details below\n------SENDER------");
        String senderName = inputName();
        String senderAddress = inputAddress();
        String senderCity = inputCity();
        String senderState = inputState();
        int senderZipcode = inputZipcode();
        Person sender = new Person(senderName, senderAddress, senderCity, senderState, senderZipcode);

        System.out.println("\n------RECIPIENT------");
        String recipientName = inputName();
        String recipientAddress = inputAddress();
        String recipientCity = inputCity();
        String recipientState = inputState();
        int recipientZipcode = inputZipcode();
        Person recipient = new Person(recipientName,recipientAddress,recipientCity,recipientState,recipientZipcode);

        Package packs = new Package(sender.name, sender.address, sender.city, sender.state,sender.zipcode,
                                    recipient.name, recipient.address, recipient.city,recipient.state, recipient.zipcode,
                                    packageWeight, packageCost, packageType);
        System.out.println(packs);
    }

    static String inputName(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Name: ");
        String name = "n";
        name = sc.nextLine();
        return name;
    }
    static String inputAddress(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Address: ");
        String address = sc.nextLine();
        return address;
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
        Scanner sc = new Scanner(System.in);
        System.out.print("Zipcode: ");
        int zipcode = sc.nextInt();
        sc.nextLine();
        return zipcode;
    }

}
