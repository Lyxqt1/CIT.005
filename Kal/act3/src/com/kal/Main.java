package com.kal;
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {
        double packageCost = 69.420D;
        char exit = 'n';
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to FedEx®, DHL® and UPS®\n");
        int packageType;
        float packageWeight;

        do {
            System.out.println("enter the details below\n-------SENDER-------");
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

            System.out.println("----Package details----");
            packageType = inputPackageType();
            packageWeight = inputPackageWeight();
            Package packs = new Package(sender.name, sender.address, sender.city, sender.state,sender.zipcode,
                    recipient.name, recipient.address, recipient.city,recipient.state, recipient.zipcode,
                    packageWeight, packageCost, packageType);
            System.out.println(packs);
                System.out.println("exit? y/n");
                exit = sc.next().charAt(0);
        }while(!(exit=='y'));

    }

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

    static int inputPackageType(){
        int packageType = 0;
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
    static float inputPackageWeight(){
        float packageWeight = 0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("enter the package weight(ounces)");
            packageWeight = sc.nextFloat();
            if((packageWeight<=0)){
                System.out.println("re-enter a valid package weight");
            }
        }while(packageWeight<=0);
        sc.nextLine();
        return packageWeight;
    }
}