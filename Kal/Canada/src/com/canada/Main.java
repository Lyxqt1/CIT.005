package com.canada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    Main(){}
    static JTextField tfcostS, tfoutputPcost,tfWeight,tfNameS, tfAddressS, tfCityS, tfStateS, tfZipS, tfnameR, tfAddressR, tfCityR, tfStateR, tfZipR;
    double packageCost =145d;
    static int pType, pCount;
    double flatFee =200;
    double addOvernight = 100;
    static JButton bAddPackage;
    static JPanel outputPanel;
    static JComboBox cbPackType;
    static JTextArea taOut;

    public static void main(String[] args) {
        Main guiPack = new Main();
        guiPack.setLayout(null);
        JFrame frame = new JFrame("Package calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 700);
        JPanel panelTop = new JPanel();
        panelTop.setLayout(null);
        outputPanel = new JPanel();
        JSplitPane s1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelTop,outputPanel);
        s1.setOrientation(SwingConstants.HORIZONTAL);
        panelTop.setMinimumSize(new Dimension(500,300));
        s1.setDividerLocation(300);
        taOut = new JTextArea();
        JLabel labelOut = new JLabel("Packages: ");
        JScrollBar scrollbarOut = new JScrollBar();
        JScrollPane scrollerList = new JScrollPane(taOut);
        scrollerList.add(scrollbarOut);
        scrollerList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollerList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollerList.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        scrollerList.setMinimumSize(new Dimension(480, 380));
        scrollerList.setPreferredSize(new Dimension(480, 380));
        labelOut.setBounds(20,0,100,20);
        scrollerList.add(labelOut);
        outputPanel.add(scrollerList);
        JPanel costPanel = new JPanel();
        JLabel textCost = new JLabel("cost per weight:");
        tfcostS = new JTextField("150",8);
        tfcostS.setEditable(false);
        String[] packageArr = {"Normal", "Two day", "Overnight"};
        JLabel packTypeLabel = new JLabel("choose shipping:");
        cbPackType = new JComboBox(packageArr);
        JLabel weightLabel = new JLabel("Weight:");
        JLabel pCostText = new JLabel("Shipping cost:");
        bAddPackage = new JButton("Add");
        tfoutputPcost = new JTextField("",7);
        tfWeight = new JFormattedTextField();
        tfoutputPcost.setEditable(false);
        bAddPackage.addActionListener(guiPack);
        bAddPackage.setSize(100,20);
        cbPackType.setBounds(150,5,130,20);
        packTypeLabel.setBounds(5,5,100,20);
        weightLabel.setBounds(5, 30,100,20);
        tfWeight.setBounds(150,30,50,20);

        JLabel sNameText = new JLabel("Sender Name: ");
        JLabel sAddressText = new JLabel("Address: ");
        JLabel sCityText = new JLabel("City: ");
        JLabel sStateText = new JLabel("State: ");
        JLabel sZipText = new JLabel("Zip Code: ");
        JLabel rNameText = new JLabel("Recipient Name: ");
        JLabel rAddressText = new JLabel("Address: ");
        JLabel rCityText = new JLabel("City: ");
        JLabel rStateText = new JLabel("State: ");
        JLabel rZipText = new JLabel("Zip Code: ");

        tfNameS = new JTextField("");
        tfAddressS = new JTextField("");
        tfCityS = new JTextField("");
        tfStateS = new JTextField("");
        tfZipS = new JTextField("");
        tfnameR = new JTextField("");
        tfAddressR = new JTextField("");
        tfCityR = new JTextField("");
        tfStateR = new JTextField("");
        tfZipR = new JTextField("");

        sNameText.setBounds(4,70,145,20);tfNameS.setBounds(150,70,250,20);
        sAddressText.setBounds(4,90,145,20);tfAddressS.setBounds(150,90,250,20);
        sCityText.setBounds(4,110,145,20);tfCityS.setBounds(150,110,250,20);
        sStateText.setBounds(4,130,145,20);tfStateS.setBounds(150,130,250,20);
        sZipText.setBounds(4,150,145,20);tfZipS.setBounds(150,150,250,20);
        rNameText.setBounds(4,190,145,20);tfnameR.setBounds(150,190,250,20);
        rAddressText.setBounds(4,210,145,20);tfAddressR.setBounds(150,210,250,20);
        rCityText.setBounds(4,230,145,20);tfCityR.setBounds(150,230,250,20);
        rStateText.setBounds(4,250,145,20);tfStateR.setBounds(150,250,250,20);
        rZipText.setBounds(4,270,145,20);tfZipR.setBounds(150,270,250,20);

        costPanel.add(bAddPackage);costPanel.add(pCostText);costPanel.add(tfoutputPcost);costPanel.add(textCost);costPanel.add(tfcostS);
        panelTop.add(cbPackType);
        panelTop.add(tfWeight);
        panelTop.add(tfNameS);
        panelTop.add(tfCityS);
        panelTop.add(tfAddressS);
        panelTop.add(tfStateS);
        panelTop.add(tfZipS);
        panelTop.add(tfnameR);
        panelTop.add(tfCityR);
        panelTop.add(tfAddressR);
        panelTop.add(tfStateR);
        panelTop.add(tfZipR);
        panelTop.add(packTypeLabel);
        panelTop.add(weightLabel);
        panelTop.add(sNameText);
        panelTop.add(sCityText);
        panelTop.add(sAddressText);
        panelTop.add(sStateText);
        panelTop.add(sZipText);
        panelTop.add(rNameText);
        panelTop.add(rAddressText);
        panelTop.add(rCityText);
        panelTop.add(rStateText);
        panelTop.add(rZipText);
        taOut.setEditable(false);
        taOut.setLineWrap(true);
        taOut.setWrapStyleWord(true);
        frame.add(BorderLayout.CENTER,s1);
        frame.add(BorderLayout.NORTH,costPanel);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        pType = cbPackType.getSelectedIndex();
        if(s.equals("Add")){
            pCount++;
            double calcWeight = Double.parseDouble(tfWeight.getText());
            Person sender = new Person(tfNameS.getText(),tfAddressS.getText(),tfCityS.getText(),tfStateS.getText(),tfZipS.getText());
            Person recipient = new Person(tfnameR.getText(),tfAddressR.getText(),tfCityR.getText(),tfStateR.getText(),tfZipR.getText());
            switch (pType) {
                case 0 -> {
                    Package packs = new Package(sender.Name, sender.Address, sender.City, sender.State, sender.Zip,
                            recipient.Name, recipient.Address, recipient.City, recipient.State, recipient.Zip,
                            calcWeight, packageCost);
                    tfoutputPcost.setText(String.valueOf(packs.finalCost));
                    taOut.append(packs.toString());
                }
                case 1 -> {
                    TwoDayPackage packsTwoDay = new TwoDayPackage(sender.Name, sender.Address, sender.City, sender.State, sender.Zip,
                            recipient.Name, recipient.Address, recipient.City, recipient.State, recipient.Zip,
                            calcWeight, packageCost, flatFee);
                    tfoutputPcost.setText(String.valueOf(packsTwoDay.finalCost));
                    taOut.append(packsTwoDay.toString());
                }
                case 2 -> {
                    OvernightPackage packOvernight = new OvernightPackage(sender.Name, sender.Address, sender.City, sender.State, sender.Zip,
                            recipient.Name, recipient.Address, recipient.City, recipient.State, recipient.Zip,
                            calcWeight, packageCost, addOvernight);
                    tfoutputPcost.setText(String.valueOf(packOvernight.finalCost));
                    taOut.append(packOvernight.toString());
                }
            }
            tfNameS.setText("");
            tfAddressS.setText("");
            tfCityS.setText("");
            tfStateS.setText("");
            tfZipS.setText("");
            tfWeight.setText("");
            tfnameR.setText("");
            tfAddressR.setText("");
            tfCityR.setText("");
            tfStateR.setText("");
            tfZipR.setText("");
        }

    }

}