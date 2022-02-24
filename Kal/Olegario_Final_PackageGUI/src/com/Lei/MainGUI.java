package com.Lei;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame implements ActionListener {
    MainGUI(){}
    static JTextField tfShippingCost;
    static JCheckBox normalShippingCB,twoDayShppingCB,overnightShippingCB;
    double packageCost = 1d;
    static int packageTypeSelect;
    static JTextField outPackageCost;
    static JButton addPackButton;
    static JTextField tfSenderName, tfSenderAddress, tfSenderCity, tfSenderState, tfSenderzip;
    static JTextField tfRecipientName, tfRecipientAddress, tfRecipientCity, tfRecipientState, tfRecipientZip;
    static JTextField tfPackWeight;

    static void packageWindow(){
        MainGUI mainGUI = new MainGUI();
        mainGUI.setLayout(null);
        JFrame frame = new JFrame("Shipping cost calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 650);

        JPanel mainPanelGUI = new JPanel();
        mainPanelGUI.setLayout(null);


        JPanel costPanel = new JPanel();
        JLabel textCost = new JLabel("cost per ounce:");
        tfShippingCost = new JTextField("1",10);
        JButton costSet = new JButton("set cost");
        costPanel.add(textCost);costPanel.add(tfShippingCost);costPanel.add(costSet);

        normalShippingCB = new JCheckBox("Standard Shipping");
        normalShippingCB.setBounds(1,30, 150,20);
        normalShippingCB.addActionListener(mainGUI);

        twoDayShppingCB = new JCheckBox("Two day Shipping");
        twoDayShppingCB.setBounds(150,30, 150,20);
        twoDayShppingCB.addActionListener(mainGUI);

        overnightShippingCB = new JCheckBox("Overnight Shipping");
        overnightShippingCB.setBounds(300,30, 150,20);
        overnightShippingCB.addActionListener(mainGUI);


        JPanel addPackagePanel = new JPanel();
        JLabel textPackageCost = new JLabel("package cost:");
        outPackageCost = new JTextField("",10);
        outPackageCost.setEditable(false);
        addPackButton = new JButton("add package");
        addPackButton.addActionListener(mainGUI);
        addPackButton.setSize(100,20);

        addPackagePanel.add(addPackButton);addPackagePanel.add(textPackageCost);addPackagePanel.add(outPackageCost);


        ButtonGroup checkboxesGroup = new ButtonGroup();
        checkboxesGroup.add(normalShippingCB);checkboxesGroup.add(twoDayShppingCB);checkboxesGroup.add(overnightShippingCB);

        mainPanelGUI.add(normalShippingCB);mainPanelGUI.add(twoDayShppingCB);mainPanelGUI.add(overnightShippingCB);

        frame.add(BorderLayout.CENTER,mainPanelGUI);
        frame.add(BorderLayout.NORTH,costPanel);
        frame.add(BorderLayout.SOUTH,addPackagePanel);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        if (s.equals("set cost")) {
            packageCost= Double.parseDouble(tfShippingCost.getText());
            System.out.println("cost per ounce updated: "+packageCost);
        }

        if(normalShippingCB.isSelected()){
            twoDayShppingCB.setSelected(false);
            overnightShippingCB.setSelected(false);
            packageTypeSelect=0;
        }
        if(twoDayShppingCB.isSelected()){
            normalShippingCB.setSelected(false);
            overnightShippingCB.setSelected(false);
            packageTypeSelect=1;
        }
        if(overnightShippingCB.isSelected()){
            normalShippingCB.setSelected(false);
            twoDayShppingCB.setSelected(false);
            packageTypeSelect=2;
        }
    }
    public static void main(String[] args) {
        packageWindow();
    }
}


