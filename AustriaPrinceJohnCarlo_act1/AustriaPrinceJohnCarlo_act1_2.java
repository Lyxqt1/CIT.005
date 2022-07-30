package com.kal;

public class Main {

    public static void main(String[] args) {
        int numberOut=0;
        for (int i = 0; i <50; i++) {
            numberOut++;
            if (numberOut%3==0||numberOut%5==0) {
                if (numberOut % 5 == 0) {
                    if(numberOut%3==0){
                        System.out.println(numberOut+" FizzBuzz");
                    }
                    else {
                        System.out.println(numberOut+ " Buzz");
                    }
                }
                else {
                    System.out.println(numberOut+" Fizz");
                }
            }
            else {
                System.out.println(numberOut);
            }
        }
    }
}
