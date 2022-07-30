package com.Lei;

import java.util.Scanner;
import java.util.Vector;
public class Main{
    static Vector<Double>calcCostVec = new Vector<Double>();
    public static void main(String[] args) {
        MainGUI.main();
        Scanner sc = new Scanner(System.in);
        char end;
        int i = 0;
        double flatFee = 200;
        double AddFeeOvernight = 100;

        System.out.println("Welcome to FedEx®, DHL® and UPS® \n");

        System.out.println("Please input details for sender: ");
        do{

            String SenderName = inputSenderName();
            String SenderAddress = inputSenderAddress();
            String SenderCity = inputSenderCity();
            String SenderState = inputSenderState();
            String SenderZIP = inputSenderZIP();
            Person Sender = new Person(SenderName, SenderAddress, SenderCity, SenderState, SenderZIP);


            System.out.println("Please input details for receiver: ");
            String ReceiverName = inputReceiverName();
            String ReceiverAddress = inputReceiverAddress();
            String ReceiverCity = inputReceiverCity();
            String ReceiverState = inputReceiverState();
            String ReceiverZIP = inputReceiverZIP();
            Person Receiver = new Person(ReceiverName, ReceiverAddress, ReceiverCity, ReceiverState, ReceiverZIP);

            System.out.println("Package details: ");
            double packagecost = inputpackagecost();
            double weight = inputweight();
            int packagetype = inputpackagetype();
            i++;

            System.out.println("Package no. " +i);
            switch (packagetype){
                case 1:{
                    Package pack= new Package(Sender.Name, Sender.Address, Sender.City, Sender.State, Sender.ZIP,
                            Receiver.Name, Receiver.Address, Receiver.City, Receiver.State, Receiver.ZIP,
                            weight, packagecost);
                    System.out.println(pack);
                    calcCostVec.add(pack.totalcost);

                    break;
                }

                case 2: {
                    TwoDayPackage pack= new TwoDayPackage(Sender.Name, Sender.Address, Sender.City, Sender.State, Sender.ZIP,
                            Receiver.Name, Receiver.Address, Receiver.City, Receiver.State, Receiver.ZIP,
                            weight, packagecost, flatFee);
                    System.out.println(pack);
                    calcCostVec.add(pack.totalcost);

                    break;
                }

                case 3: {
                    OvernightPackage pack = new OvernightPackage(Sender.Name, Sender.Address, Sender.City, Sender.State, Sender.ZIP,
                            Receiver.Name, Receiver.Address, Receiver.City, Receiver.State, Receiver.ZIP,
                            weight, packagecost, AddFeeOvernight);
                    System.out.println(pack);
                    calcCostVec.add(pack.totalcost);

                    break;
                }
            }
            do{
                System.out.println("Do you want to add another package? 'y for yes and 'n' for no");
                end = sc.next().charAt(0);
            }while(!(end == 'y' || end == 'n'));

        }while (!(end == 'n'));
        total();

    }



    static String inputSenderName(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Name: ");
        String name;
        name = sc.nextLine();
        return name;
    }
    static String inputSenderAddress(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Address: ");
        String address = sc.nextLine();
        return address;
    }
    static String inputSenderCity(){
        Scanner sc = new Scanner(System.in);
        System.out.print("City: ");
        String city = sc.nextLine();
        return city;
    }
    static String inputSenderState(){
        Scanner sc = new Scanner(System.in);
        System.out.print("State: ");
        String state = sc.nextLine();
        return state;
    }
    static String inputSenderZIP(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Zipcode: ");
        String ZIP = sc.nextLine();
        sc.nextLine();
        return ZIP;
    }

    static String inputReceiverName(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Name: ");
        String name;
        name = sc.nextLine();
        return name;
    }
    static String inputReceiverAddress(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Address: ");
        String address = sc.nextLine();
        return address;
    }
    static String inputReceiverCity(){
        Scanner sc = new Scanner(System.in);
        System.out.print("City: ");
        String city = sc.nextLine();
        return city;
    }
    static String inputReceiverState(){
        Scanner sc = new Scanner(System.in);
        System.out.print("State: ");
        String state = sc.nextLine();
        return state;
    }
    static String inputReceiverZIP(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Zipcode: ");
        String zipcode = sc.nextLine();
        sc.nextLine();
        return zipcode;
    }


    static int inputpackagetype(){
        int packagetype;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose your shipping option: ");
        System.out.println("1. Standard Shipping\n 2. Two Day Shipping\n 3. Overnight Shipping");
        packagetype = sc.nextInt();
        return packagetype;

    }
    static double inputpackagecost(){
        double packagecost;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter pakcage cost in ounce: ");
            packagecost = sc.nextDouble();
            if ((packagecost <= 0)){
                System.out.println("invalid weight!");
            }
        }while(packagecost <= 0);
        sc.nextLine();
        return packagecost;
    }

    static double inputweight(){
        double weight;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter pakcage weight in ounce: ");
            weight = sc.nextDouble();
            if ((weight <= 0)){
                System.out.println("invalid weight!");
            }
        }while(weight <= 0);
        sc.nextLine();
        return weight;
    }

    static Object total(){
        double sum = calcCostVec.stream().mapToDouble(Double::valueOf).sum();
        System.out.println("total payment of packages: " +sum+ "PHP. Thankyou!");
        return sum+" PHP";
    }
}
