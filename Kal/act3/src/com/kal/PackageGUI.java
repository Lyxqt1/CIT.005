package com.kal;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.table.JTableHeader;

import static com.kal.Main.*;
import static com.kal.TestingPack.*;


public class PackageGUI extends JFrame implements ActionListener{
    static JTextField costTf;
    static JCheckBox stdShipping;
    static JCheckBox tdShipping;
    static JCheckBox onShipping;
    static JTextField inputW;
    static JButton calculate;
    static JTextField outputCost;
    static JTextField outuptTotal;

    static JTextField senderName;
    static JTextField senderAddress;
    static JTextField senderCity;
    static JTextField senderState;
    static JTextField senderZip;

    static JTextField recipientName;
    static JTextField recipientAddress;
    static JTextField recipientCity;
    static JTextField recipientState;
    static JTextField recipientZip;

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
        JMenu m2 = new JMenu("info");
        JMenuItem myName = new JMenuItem("dev: 190041");
        m2.add(myName);
        mb.add(m1);
        mb.add(m2);
        JButton setCost = new JButton("save cost");
        setCost.addActionListener(pGUI);
        costTf = new JTextField(Double.toString(packageCost),10);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        m1.add(costTf);
        m1.add(setCost);

        stdShipping = new JCheckBox("Standard Shipping",true);
        tdShipping = new JCheckBox("Two-Day Shipping",false);
        onShipping = new JCheckBox("Overnight Shipping",false);
        stdShipping.addActionListener(pGUI);
        tdShipping.addActionListener(pGUI);
        onShipping.addActionListener(pGUI);

        stdShipping.setBounds(0,1,150,20);
        tdShipping.setBounds(150,1,150,20);
        onShipping.setBounds(300, 1, 150,20);
        JLabel bgText=new JLabel();
        ButtonGroup bg = new ButtonGroup();
        bg.add(stdShipping);bg.add(tdShipping);bg.add(onShipping);



        JLabel textW = new JLabel("weight in ounce:");
        inputW = new JTextField(10);
        textW.setBounds(5, 21,100,20);
        inputW.setBounds(100,21,50,20);

        JPanel calc = new JPanel();
        JLabel textCost = new JLabel("package cost: ");
        JLabel overallCost = new JLabel("total cost: ");
        outuptTotal = (new JTextField("",10));
        outputCost = new JTextField("",6);
        calculate = new JButton("calculate");
        calculate.addActionListener(pGUI);
        calculate.setSize( 100,20);
        calc.add(calculate);calc.add(textCost);calc.add(outputCost);calc.add(overallCost);calc.add(outuptTotal);

        JLabel textSender = new JLabel("Sender:");
        textSender.setBounds(5,41,150,20);
        JLabel textSenderName = new JLabel("name: ");
        senderName = new JTextField("");
        textSenderName.setBounds(5,61,150,20);
        senderName.setBounds(100,61,250,20);

        JLabel textSenderAddress = new JLabel("address: ");
        senderAddress = new JTextField("");
        textSenderAddress.setBounds(5,81,150,20);
        senderAddress.setBounds(100,81,250,20);

        JLabel textSenderCity = new JLabel("city: ");
        senderCity = new JTextField("");
        textSenderCity.setBounds(5,101,150,20);
        senderCity.setBounds(100,101,250,20);

        JLabel textSenderState = new JLabel("state: ");
        senderState = new JTextField("");
        textSenderState.setBounds(5,121,150,20);
        senderState.setBounds(100,121,250,20);

        JLabel textSenderZip = new JLabel("zip code: ");
        senderZip = new JTextField("");
        textSenderZip.setBounds(5,141,150,20);
        senderZip.setBounds(100,141,250,20);



        JLabel textRecipient = new JLabel("Recipient:");
        textRecipient.setBounds(5,161,150,20);
        JLabel textRecipientName = new JLabel("name: ");
        recipientName = new JTextField("");
        textRecipientName.setBounds(5,181,150,20);
        recipientName.setBounds(100,181,250,20);

        JLabel textRecipientAddress = new JLabel("address: ");
        recipientAddress = new JTextField("");
        textRecipientAddress.setBounds(5,201,150,20);
        recipientAddress.setBounds(100,201,250,20);

        JLabel textRecipientCity = new JLabel("city: ");
        recipientCity = new JTextField("");
        textRecipientCity.setBounds(5,221,150,20);
        recipientCity.setBounds(100,221,250,20);

        JLabel textRecipientState = new JLabel("state: ");
        recipientState = new JTextField("");
        textRecipientState.setBounds(5,241,150,20);
        recipientState.setBounds(100,241,250,20);

        JLabel textRecipientZip = new JLabel("zip code: ");
        recipientZip = new JTextField("");
        textRecipientZip.setBounds(5,261,150,20);
        recipientZip.setBounds(100,261,250,20);
        frame.getContentPane().add(BorderLayout.NORTH, mb);

        mainPanel.add(stdShipping); mainPanel.add(tdShipping); mainPanel.add(onShipping);
        mainPanel.add(textW);mainPanel.add(inputW);
        mainPanel.add(textSender);
        mainPanel.add(textSenderName);mainPanel.add(senderName);
        mainPanel.add(textSenderCity);mainPanel.add(senderCity);
        mainPanel.add(textSenderAddress);mainPanel.add(senderAddress);
        mainPanel.add(textSenderState);mainPanel.add(senderState);
        mainPanel.add(textSenderZip);mainPanel.add(senderZip);
        mainPanel.add(textRecipient);
        mainPanel.add(textRecipientName);mainPanel.add(recipientName);
        mainPanel.add(textRecipientCity);mainPanel.add(recipientCity);
        mainPanel.add(textRecipientAddress);mainPanel.add(recipientAddress);
        mainPanel.add(textRecipientState);mainPanel.add(recipientState);
        mainPanel.add(textRecipientZip);mainPanel.add(recipientZip);
        frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
        frame.getContentPane().add(BorderLayout.SOUTH,calc);

        frame.setVisible(true);
    }
    public static void main(String[] args) {
        mainWindow();
    }
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("save cost")) {
            packageCost= Double.parseDouble(costTf.getText());
            System.out.println(packageCost);
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
        if(s.equals("calculate")){

            double calcWeight = Double.parseDouble(inputW.getText());

            Person sender = new Person(senderName.getText(),senderAddress.getText(),senderCity.getText(),senderState.getText(),senderZip.getText()); //creates Person with constructor, "sender" and "recipient" then passes those to Package below.
            Person recipient = new Person(recipientName.getText(),recipientAddress.getText(),recipientCity.getText(),recipientState.getText(),recipientZip.getText());

            switch (packageType) {//switch for different packages
                case 0 -> {
                    Package pack = new Package(sender.name, sender.address, sender.city, sender.state, sender.zipcode,
                            recipient.name, recipient.address, recipient.city, recipient.state, recipient.zipcode,
                            calcWeight, packageCost);
                    System.out.println(pack);//prints a toString method. check the other java file.
                    outputCost.setText(String.valueOf(pack.totalCost));
                    totalCostVec.add(pack.totalCost);//adds the total cost of this instance of package to the vector
                    //all cases are the same. the only difference is calcuations of totalCost.
                    String  i = String.valueOf(totalPackage());
                    outuptTotal.setText(i);
                }
                case 1 -> {
                    TwoDayPackage pack = new TwoDayPackage(sender.name, sender.address, sender.city, sender.state, sender.zipcode,
                            recipient.name, recipient.address, recipient.city, recipient.state, recipient.zipcode,
                            calcWeight, packageCost, flatFee);
                    System.out.println(pack);//prints a toString method. check the other java file.
                    totalCostVec.add(pack.totalCost);
                    outputCost.setText(String.valueOf(pack.totalCost));
                    String  i = String.valueOf(totalPackage());
                    outuptTotal.setText(i);
                }
                case 2 -> {
                    OvernightPackage pack = new OvernightPackage(sender.name, sender.address, sender.city, sender.state, sender.zipcode,
                            recipient.name, recipient.address, recipient.city, recipient.state, recipient.zipcode,
                            calcWeight, packageCost, additionalOvernight);
                    System.out.println(pack);//prints a toString method. check the other java file.
                    outputCost.setText(String.valueOf(pack.totalCost));
                    totalCostVec.add(pack.totalCost);
                    String  i = String.valueOf(totalPackage());
                    outuptTotal.setText(i);

                }
            }
        }
    }
}
