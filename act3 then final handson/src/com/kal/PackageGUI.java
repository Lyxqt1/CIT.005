package com.kal;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JScrollPane;

import static com.kal.Main.*;

public class PackageGUI extends JFrame implements ActionListener{
    public static double packageCost = 69D;
    public static int packageType = 0;
    public static int packageCount = 0;
    static JTextField costTf;
    static JCheckBox stdShipping;
    static JCheckBox tdShipping;
    static JCheckBox onShipping;
    static JFormattedTextField inputW;
    static JButton calculate;
    static JTextField outputCost;
    static JTextField outputTotal;
    static JTextArea textAreaList;
    static JTextField senderName;
    static JTextField senderAddress;
    static JTextField senderCity;
    static JTextField senderState;
    static JTextField senderZip;
    static JTextField recipientName;
    static JTextField recipientAddress;
    static JTextField recipientCity;
    static JTextField recipientState;
    static JPanel listPanel;
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
        frame.setSize(490, 410);
        JTabbedPane tp=new JTabbedPane();

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
        ButtonGroup bg = new ButtonGroup();
        bg.add(stdShipping);bg.add(tdShipping);bg.add(onShipping);



        JLabel textW = new JLabel("weight(oz):");
        inputW = new JFormattedTextField();
        textW.setBounds(5, 21,70,20);
        inputW.setBounds(70,21,50,20);

        @FunctionalInterface
        interface SimpleDocumentListener extends DocumentListener {
            void update(DocumentEvent e);

            @Override
            default void insertUpdate(DocumentEvent e) {
                update(e);
            }
            @Override
            default void removeUpdate(DocumentEvent e) {
                update(e);
            }
            @Override
            default void changedUpdate(DocumentEvent e) {
                update(e);
            }
        }
        inputW.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                if(Objects.equals(inputW.getText(), "")){
                    calculate.setEnabled(doublecheckWeight());
                }else{
                    calculate.setEnabled(doublecheckWeight());
                }
            }
        });
        costTf.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                if(Objects.equals(costTf.getText(),"")){
                    setCost.setEnabled(doublecheckCost());
                }else{
                    setCost.setEnabled(doublecheckCost());
                }
            }
        });

        JPanel calc = new JPanel();
        JLabel textCost = new JLabel("package cost: ");
        JLabel overallCost = new JLabel("accumulated cost: ");
        outputTotal = (new JTextField("",10));
        outputCost = new JTextField("",6);
        outputTotal.setEditable(false);
        outputCost.setEditable(false);
        calculate = new JButton("calculate");
        calculate.addActionListener(pGUI);
        calculate.setSize( 70,20);
        calculate.setEnabled(false);
        calc.add(calculate);calc.add(textCost);calc.add(outputCost);calc.add(overallCost);calc.add(outputTotal);

        JLabel textSender = new JLabel("----------------------------------------------------Sender----------------------------------------------------");
        textSender.setBounds(5,41,500,20);
        JLabel textSenderName = new JLabel("name: ");
        senderName = new JTextField("");
        textSenderName.setBounds(5,61,150,20);
        senderName.setBounds(70,61,390,20);

        JLabel textSenderAddress = new JLabel("address: ");
        senderAddress = new JTextField("");
        textSenderAddress.setBounds(5,81,150,20);
        senderAddress.setBounds(70,81,390,20);

        JLabel textSenderCity = new JLabel("city: ");
        senderCity = new JTextField("");
        textSenderCity.setBounds(5,101,150,20);
        senderCity.setBounds(70,101,390,20);

        JLabel textSenderState = new JLabel("state: ");
        senderState = new JTextField("");
        textSenderState.setBounds(5,121,150,20);
        senderState.setBounds(70,121,390,20);

        JLabel textSenderZip = new JLabel("zip code: ");
        senderZip = new JTextField("");
        textSenderZip.setBounds(5,141,150,20);
        senderZip.setBounds(70,141,390,20);



        JLabel textRecipient = new JLabel("---------------------------------------------------Recipient---------------------------------------------------");
        textRecipient.setBounds(5,161,500,20);
        JLabel textRecipientName = new JLabel("name: ");
        recipientName = new JTextField("");
        textRecipientName.setBounds(5,181,150,20);
        recipientName.setBounds(70,181,390,20);

        JLabel textRecipientAddress = new JLabel("address: ");
        recipientAddress = new JTextField("");
        textRecipientAddress.setBounds(5,201,150,20);
        recipientAddress.setBounds(70,201,390,20);

        JLabel textRecipientCity = new JLabel("city: ");
        recipientCity = new JTextField("");
        textRecipientCity.setBounds(5,221,150,20);
        recipientCity.setBounds(70,221,390,20);

        JLabel textRecipientState = new JLabel("state: ");
        recipientState = new JTextField("");
        textRecipientState.setBounds(5,241,150,20);
        recipientState.setBounds(70,241,390,20);

        JLabel textRecipientZip = new JLabel("zip code: ");
        recipientZip = new JTextField("");
        textRecipientZip.setBounds(5,261,150,20);
        recipientZip.setBounds(70,261,390,20);


        frame.getContentPane().add(BorderLayout.NORTH, mb);
        listPanel = new JPanel();
        packageListPanel();
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
        frame.getContentPane().add(BorderLayout.CENTER,tp);
        frame.getContentPane().add(BorderLayout.SOUTH,calc);
        tp.add("add package",mainPanel);
        tp.add("package list",listPanel);
        frame.setVisible(true);
    }
    static void packageListPanel(){
        textAreaList = new JTextArea("");
        textAreaList.setEditable(false);
        textAreaList.setLineWrap(true);
        textAreaList.setWrapStyleWord(true);
        JScrollBar listScrollBar = new JScrollBar();
        JScrollPane scrollPackageList = new JScrollPane(textAreaList);
        scrollPackageList.add(listScrollBar);
        scrollPackageList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPackageList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPackageList.setBorder(BorderFactory.createEmptyBorder(0, 7, 0, 7));
        scrollPackageList.setMinimumSize(new Dimension(480, 280));
        scrollPackageList.setPreferredSize(new Dimension(480, 280));
        listPanel.add(scrollPackageList);
    }

    public static boolean doublecheckWeight(){
        try{
            double value = Double.parseDouble(inputW.getText());
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public static boolean doublecheckCost(){
        try{
            double value = Double.parseDouble(costTf.getText());
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void actionPerformed(ActionEvent e) {

        String s = e.getActionCommand();
        if (s.equals("save cost")) {
            packageCost= Double.parseDouble(costTf.getText());
            System.out.println("cost per ounce updated: "+packageCost);
        }
        if(Objects.equals(inputW.getText(), "")){
            calculate.setEnabled(false);
        }else {
            calculate.setEnabled(true);
        }
        if(stdShipping.isSelected()){
            tdShipping.setSelected(false);
            onShipping.setSelected(false);
            packageType=0;
        }
        if(tdShipping.isSelected()){
            stdShipping.setSelected(false);
            onShipping.setSelected(false);
            packageType=1;
        }
        if(onShipping.isSelected()){
            stdShipping.setSelected(false);
            tdShipping.setSelected(false);
            packageType=2;
        }
        if(s.equals("calculate")){
            packageCount++;
            double calcWeight = Double.parseDouble(inputW.getText());

            Person sender = new Person(senderName.getText(),senderAddress.getText(),senderCity.getText(),senderState.getText(),senderZip.getText()); //creates Person with constructor, "sender" and "recipient" then passes those to Package below.
            Person recipient = new Person(recipientName.getText(),recipientAddress.getText(),recipientCity.getText(),recipientState.getText(),recipientZip.getText());

            switch (packageType) {//switch for different packages
                case 0 -> {
                    Package pack = new Package(sender.name, sender.address, sender.city, sender.state, sender.zipcode,
                            recipient.name, recipient.address, recipient.city, recipient.state, recipient.zipcode,
                            calcWeight, packageCost);
                   //prints a toString method. check the other java file.
                    outputCost.setText(String.valueOf(pack.totalCost));
                    System.out.println(pack);
                    totalCostVec.add(pack.totalCost);//adds the total cost of this instance of package to the vector
                    //all cases are the same. the only difference is calculations of totalCost.
                    String  i = String.valueOf(totalPackage());
                    outputTotal.setText(i);
                    textAreaList.append(pack.toString());
                }
                case 1 -> {
                    TwoDayPackage pack = new TwoDayPackage(sender.name, sender.address, sender.city, sender.state, sender.zipcode,
                            recipient.name, recipient.address, recipient.city, recipient.state, recipient.zipcode,
                            calcWeight, packageCost, flatFee);
                    System.out.println(pack);//prints a toString method. check the other java file.
                    totalCostVec.add(pack.totalCost);
                    outputCost.setText(String.valueOf(pack.totalCost));
                    String  i = String.valueOf(totalPackage());
                    outputTotal.setText(i);
                    textAreaList.append(pack.toString());
                }
                case 2 -> {
                    OvernightPackage pack = new OvernightPackage(sender.name, sender.address, sender.city, sender.state, sender.zipcode,
                            recipient.name, recipient.address, recipient.city, recipient.state, recipient.zipcode,
                            calcWeight, packageCost, additionalOvernight);
                    System.out.println(pack);//prints a toString method. check the other java file.
                    outputCost.setText(String.valueOf(pack.totalCost));
                    totalCostVec.add(pack.totalCost);
                    String  i = String.valueOf(totalPackage());
                    outputTotal.setText(i);
                    textAreaList.append(pack.toString());

                }
            }

            senderName.setText(""); senderAddress.setText("");senderCity.setText("");senderState.setText("");senderZip.setText("");
            inputW.setText("");
            recipientName.setText("");recipientAddress.setText("");recipientCity.setText("");recipientState.setText("");recipientZip.setText("");
        }
    }

    public static void main() {
        mainWindow();
    }
}
