package com.kal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.table.JTableHeader;


public class PackageGUI extends JFrame implements ActionListener{
    static JTextField costTf;
    static JCheckBox stdShipping;
    static JCheckBox tdShipping;
    static JCheckBox onShipping;
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

        stdShipping = new JCheckBox("Standard Shipping",true);
        tdShipping = new JCheckBox("Two-Day Shipping",false);
        onShipping = new JCheckBox("Overnight Shipping",false);
        stdShipping.addActionListener(pGUI);
        tdShipping.addActionListener(pGUI);
        onShipping.addActionListener(pGUI);

        stdShipping.setBounds(0,1,150,30);
        tdShipping.setBounds(150,1,150,30);
        onShipping.setBounds(300, 1, 150,30);
        JLabel bgText=new JLabel();
        ButtonGroup bg = new ButtonGroup();
        bg.add(stdShipping);bg.add(tdShipping);bg.add(onShipping);
        bgText.add(stdShipping);bgText.add(tdShipping);bgText.add(onShipping);

        JTextField textW = new JTextField("weight in ounce");
        JTextField inputW = new JTextField();


        frame.add(bgText);

        //Creating the MenuBar and adding components

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, mb);

        frame.setVisible(true);
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
        if(stdShipping.isSelected()){
            tdShipping.setSelected(false);
            onShipping.setSelected(false);
            TestingPack.packageType=0;
            System.out.println(TestingPack.packageType);
        }
        if(tdShipping.isSelected()){
            stdShipping.setSelected(false);
            onShipping.setSelected(false);
            TestingPack.packageType=1;
            System.out.println(TestingPack.packageType);
        }
        if(onShipping.isSelected()){
            stdShipping.setSelected(false);
            tdShipping.setSelected(false);
            TestingPack.packageType=2;
            System.out.println(TestingPack.packageType);
        }
    }
}

