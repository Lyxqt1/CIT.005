package com.kal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PackageGUI extends JFrame implements ActionListener{
    static JTextField costTf;
    PackageGUI(){}
    //Creating the panel at bottom and adding components
    /**
     */
    static void mainWindow(){
        //Creating the Frame
        PackageGUI pGUI = new PackageGUI();
        JFrame frame = new JFrame("Welcome to FedEx®, DHL® and UPS®");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 690);

        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Set Standard Fee");
        mb.add(m1);
        JButton setCost = new JButton("save cost");
        setCost.addActionListener(pGUI);
        costTf = new JTextField(Double.toString(TestingPack.packageCost),10);

        m1.add(costTf);
        m1.add(setCost);

        JRadioButton r1=new JRadioButton("Standard Shipping");
        JRadioButton r2=new JRadioButton("Two-Day Shipping");
        JRadioButton r3=new JRadioButton("Overnight Shipping");
        r1.setBounds(0,30,150,30);
        r2.setBounds(150,30,150,30);
        r3.setBounds(300, 30, 150,30);
        JTextArea bg=new JTextArea();
        bg.setEditable(false);
        bg.add(r1);bg.add(r2);bg.add(r3);
        frame.add(bg);

        //Creating the MenuBar and adding components

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, mb);

        frame.show(true);
    }
    public static void main(String[] args) {
        mainWindow();
    }
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("save cost")) {
            TestingPack.packageCost= Double.parseDouble(costTf.getText());
            System.out.println(TestingPack.packageCost);
        }
    }
}

