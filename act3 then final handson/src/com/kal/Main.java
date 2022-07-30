package com.kal;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static final double flatFee = 200;//given
    public static final double additionalOvernight = 100;//given
    static Vector<Double> totalCostVec = new Vector<Double>();//storing the sum of all total cost of each packages
    public static void main(String[] args) {
        PackageGUI.main();
        double packageCost = 69.42d;//base cost for packages, defined by the company which is me
        char exit;//char for exiting the loop
        Scanner sc = new Scanner(System.in);
        int i = 0; //tracks number of packages
        System.out.println("Welcome to FedEx®, DHL® and UPS®\n");
        do {
            System.out.println("enter the details below\n----------------SENDER----------------");
            String senderName = String.valueOf(PackageGUI.senderName); //all of these input prints the data needed then asks the user for an input corresponding to that then returns it.
            String senderAddress = inputAddress();
            String senderCity = inputCity();
            String senderState = inputState();
            String senderZipcode = inputZipcode();
            System.out.println("\n----------------RECIPIENT----------------");
            String recipientName = inputName();
            String recipientAddress = inputAddress();
            String recipientCity = inputCity();
            String recipientState = inputState();
            String recipientZipcode = inputZipcode();
            System.out.println("----------------Package details----------------");
            double packageWeight = inputPackageWeight();
            int packageType = inputPackageType();//packagetype determines the switch case. end of inputs
            i++;//increment for package count
            Person sender = new Person(senderName, senderAddress, senderCity, senderState, senderZipcode); //creates Person with constructor, "sender" and "recipient" then passes those to Package below.
            Person recipient = new Person(recipientName, recipientAddress, recipientCity, recipientState, recipientZipcode);


            System.out.println("----------------PACKAGE "+i+"----------------");
            switch (packageType) {//switch for different packages
                case 1 -> {
                    Package packs = new Package(sender.name, sender.address, sender.city, sender.state, sender.zipcode,
                            recipient.name, recipient.address, recipient.city, recipient.state, recipient.zipcode,
                            packageWeight, packageCost);
                    System.out.println(packs);//prints a toString method. check the other java file.
                    totalCostVec.add(packs.totalCost);//adds the total cost of this instance of package to the vector
                    //all cases are the same. the only difference is calcuations of totalCost.
                }
                case 2 -> {
                    TwoDayPackage packs = new TwoDayPackage(sender.name, sender.address, sender.city, sender.state, sender.zipcode,
                            recipient.name, recipient.address, recipient.city, recipient.state, recipient.zipcode,
                            packageWeight, packageCost, flatFee);
                    System.out.println(packs);
                    totalCostVec.add(packs.totalCost);
                }
                case 3 -> {
                    OvernightPackage packs = new OvernightPackage(sender.name, sender.address, sender.city, sender.state, sender.zipcode,
                            recipient.name, recipient.address, recipient.city, recipient.state, recipient.zipcode,
                            packageWeight, packageCost, additionalOvernight);
                    System.out.println(packs);
                    totalCostVec.add(packs.totalCost);
                }
            }
            do{
                System.out.println("add another package? y/n");//ask if the user wants to add or exit
                exit = sc.next().charAt(0);
            }while(!(exit=='y'||exit=='n'));
        }while(!(exit=='n'));//loop then adds another package if not the user opted not to exit
        totalPackage();
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
    static String inputZipcode(){
        String zipcode;
        Scanner sc = new Scanner(System.in);
        System.out.println("Zipcode:");
        zipcode = sc.nextLine();
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

    static double totalPackage(){//method for adding all of the values from the vector of all costs of packages
        double sum = totalCostVec.stream()
                .mapToDouble(Double::valueOf)
                .sum();
        System.out.println("total sum of all packages: "+sum + " PHP");
        return sum;
    }
}