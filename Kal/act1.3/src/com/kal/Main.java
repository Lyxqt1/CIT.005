package com.kal;
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int n=10;
        Scanner sc=new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        int[] numArray = new int[10];
        System.out.println("Enter 10 numbers: ");

        for(int i=0; i<n; i++) {
            numArray[i]=sc.nextInt();
        }

        System.out.println("which way should the numbers inputted be ordered?\na.)Ascending order \nb.)Descending order");
        char letterInput = scanner.next().charAt(0);
        Arrays.sort(numArray);
        switch (letterInput){
            case 'a':
                System.out.println("Ascending order: ");
                for (int i = 0; i < 10; i++) {
                    System.out.println(numArray[i]);
                }
                break;
            case 'b':
                System.out.println("Descending order: ");
                for (int i = 9; i > 0; i--) {
                    System.out.println(numArray[i]);
                }
                break;
        }
    }
}