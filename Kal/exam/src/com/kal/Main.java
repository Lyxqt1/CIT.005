package com.kal;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        int inputA;
        int inputB;
        int swapC;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter two values");
        inputA = scanner.nextInt();
        inputB = scanner.nextInt();
        System.out.println("First value: a = " + inputA +", b: "+inputB);
        swapC = inputA;
        inputA = inputB;
        inputB = swapC;
        System.out.println("swapped value: a = " + inputA +",  b: "+inputB);
    }
}
