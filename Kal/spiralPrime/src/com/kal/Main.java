package com.kal;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        int desiredNum = 25000;
        int fWidth = 800;
        int fHeight = 800;
        int turnCount = 1;
        int numSteps = 1;
        int x = fWidth/2;
        int y = fHeight/2;
        int state = 0;
        int stepNow = 1;
        JFrame f = new JFrame("Ulam Spiral");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(fWidth,fHeight);
        f.setLayout(null);
        int stepSize = 5;
        JTextField[] numbersOut = new JTextField[desiredNum];
        for(int i = 0; i < desiredNum; i++){

            String strNum = String.valueOf(stepNow);
            numbersOut[i] = new JTextField(strNum);
            boolean primeCheck = true;
            numbersOut[i].setBackground(Color.black);
            numbersOut[i].setForeground(Color.red);
            numbersOut[i].setEditable(false);
            for(int j = 2; j<=Math.sqrt(stepNow); j++){
                if(stepNow % j == 0){
                    numbersOut[i].setBackground(Color.white);
                    numbersOut[i].setForeground(Color.black);
                }
            }
            if(stepNow == 1){
                numbersOut[i].setBackground(Color.green);
            }

            f.add(numbersOut[i]);
            numbersOut[i].setBounds(x, y, stepSize,stepSize);
            f.add(numbersOut[i]);
            switch (state){
                case 0 ->
                        x += stepSize;
                case 1 ->
                        y -= stepSize;
                case 2 ->
                        x -= stepSize;
                case 3 ->
                        y += stepSize;
            }
            if (stepNow % numSteps == 0){
                state = (state+1)%4;
                turnCount++;
                if(turnCount %2 == 0){
                    numSteps++;
                }
            }
            stepNow++;
        }
        f.show();
    }
}
