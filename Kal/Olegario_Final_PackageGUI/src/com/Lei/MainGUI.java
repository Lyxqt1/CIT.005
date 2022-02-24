package com.Lei;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.Lei.Main.calcCostVec;
import static com.Lei.Main.total;

public class MainGUI extends JFrame implements ActionListener {
    MainGUI(){}
    static JTextField tfShippingCost;
    static JCheckBox normalShippingCB,twoDayShppingCB,overnightShippingCB;
    double packageCost = 100d;
    static int packageTypeSelect, packsCount;
    double flatFee =200;
    double additionalOvernight = 100;
    static JTextField outPackageCost;
    static JButton addPackButton;
    static JTextField tfSenderName, tfSenderAddress, tfSenderCity, tfSenderState, tfSenderZip;
    static JTextField tfRecipientName, tfRecipientAddress, tfRecipientCity, tfRecipientState, tfRecipientZip;
    static JTextField tfPackWeight;
    static JPanel outputListPanel;
    static JComboBox cbShippingType;
    static JTextArea taOutput;
    static JTextField sumPackages;

    static void packageWindow(){
        MainGUI mainGUI = new MainGUI();
        mainGUI.setLayout(null);
        JFrame frame = new JFrame("Shipping cost calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(840, 370);

        JPanel mainPanelGUI = new JPanel();
        mainPanelGUI.setLayout(null);
        outputListPanel = new JPanel();
        JSplitPane s1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,outputListPanel, mainPanelGUI);
        s1.setOrientation(SwingConstants.VERTICAL);

        taOutput = new JTextArea();
        JLabel outputLabel = new JLabel("Package List: ");

        outputListPanel.setSize(420,360);
        taOutput.setEditable(false);
        taOutput.setLineWrap(true);
        taOutput.setWrapStyleWord(true);
        JScrollBar outputScrollBar = new JScrollBar();
        JScrollPane scrollPackageList = new JScrollPane(taOutput);
        scrollPackageList.add(outputScrollBar);
        scrollPackageList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPackageList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPackageList.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        scrollPackageList.setMinimumSize(new Dimension(420, 280));
        scrollPackageList.setPreferredSize(new Dimension(420, 280));
        outputLabel.setBounds(20,0,100,20);
        scrollPackageList.add(outputLabel);
        outputListPanel.add(BorderLayout.SOUTH,scrollPackageList);



        JPanel costPanel = new JPanel();
        JLabel textCost = new JLabel("cost per ounce:");
        tfShippingCost = new JTextField("100",10);
        JButton costSet = new JButton("set cost");
        costPanel.add(textCost);costPanel.add(tfShippingCost);costPanel.add(costSet);

        String[] shippingType = {"Standard", "Two-day", "Overnight"};
        JLabel labelShippingType = new JLabel("Select shipping:");
        cbShippingType = new JComboBox(shippingType);
        cbShippingType.setBounds(100,5,130,20);
        labelShippingType.setBounds(5,5,100,20);





        JLabel labelWeight = new JLabel("Weight:");
        tfPackWeight = new JFormattedTextField();
        labelWeight.setBounds(5, 30,100,20);
        tfPackWeight.setBounds(100,30,50,20);

        JLabel textPackageCost = new JLabel("Package cost:");
        outPackageCost = new JTextField("",10);
        outPackageCost.setEditable(false);
        addPackButton = new JButton("Add package");
        addPackButton.addActionListener(mainGUI);
        addPackButton.setSize(100,20);

        JLabel textSender = new JLabel("Sender:");
        textSender.setBounds(5,50,150,20);
        JLabel textSenderName = new JLabel("Name: ");
        tfSenderName = new JTextField("");
        textSenderName.setBounds(5,70,150,20);
        tfSenderName.setBounds(100,70,250,20);

        JLabel textSenderAddress = new JLabel("Address: ");
        tfSenderAddress = new JTextField("");
        textSenderAddress.setBounds(5,90,150,20);
        tfSenderAddress.setBounds(100,90,250,20);

        JLabel textSenderCity = new JLabel("City: ");
        tfSenderCity = new JTextField("");
        textSenderCity.setBounds(5,110,150,20);
        tfSenderCity.setBounds(100,110,250,20);

        JLabel textSenderState = new JLabel("State: ");
        tfSenderState = new JTextField("");
        textSenderState.setBounds(5,130,150,20);
        tfSenderState.setBounds(100,130,250,20);

        JLabel textSenderZip = new JLabel("Zip Code: ");
        tfSenderZip = new JTextField("");
        textSenderZip.setBounds(5,150,150,20);
        tfSenderZip.setBounds(100,150,250,20);



        JLabel textRecipient = new JLabel("Recipient:");
        textRecipient.setBounds(5,170,150,20);
        JLabel textRecipientName = new JLabel("Name: ");
        tfRecipientName = new JTextField("");
        textRecipientName.setBounds(5,190,150,20);
        tfRecipientName.setBounds(100,190,250,20);

        JLabel textRecipientAddress = new JLabel("Address: ");
        tfRecipientAddress = new JTextField("");
        textRecipientAddress.setBounds(5,210,150,20);
        tfRecipientAddress.setBounds(100,210,250,20);

        JLabel textRecipientCity = new JLabel("City: ");
        tfRecipientCity = new JTextField("");
        textRecipientCity.setBounds(5,230,150,20);
        tfRecipientCity.setBounds(100,230,250,20);

        JLabel textRecipientState = new JLabel("State: ");
        tfRecipientState = new JTextField("");
        textRecipientState.setBounds(5,250,150,20);
        tfRecipientState.setBounds(100,250,250,20);

        JLabel textRecipientZip = new JLabel("Zip Code: ");
        tfRecipientZip = new JTextField("");
        textRecipientZip.setBounds(5,270,150,20);
        tfRecipientZip.setBounds(100,270,250,20);



        costPanel.add(addPackButton);costPanel.add(textPackageCost);costPanel.add(outPackageCost);


        ButtonGroup checkboxesGroup = new ButtonGroup();
        checkboxesGroup.add(normalShippingCB);checkboxesGroup.add(twoDayShppingCB);checkboxesGroup.add(overnightShippingCB);

        mainPanelGUI.add(labelShippingType); mainPanelGUI.add(cbShippingType);
        mainPanelGUI.add(labelWeight);mainPanelGUI.add(tfPackWeight);
        mainPanelGUI.add(textSender);
        mainPanelGUI.add(textSenderName);mainPanelGUI.add(tfSenderName);
        mainPanelGUI.add(textSenderCity);mainPanelGUI.add(tfSenderCity);
        mainPanelGUI.add(textSenderAddress);mainPanelGUI.add(tfSenderAddress);
        mainPanelGUI.add(textSenderState);mainPanelGUI.add(tfSenderState);
        mainPanelGUI.add(textSenderZip);mainPanelGUI.add(tfSenderZip);
        mainPanelGUI.add(textRecipient);
        mainPanelGUI.add(textRecipientName);mainPanelGUI.add(tfRecipientName);
        mainPanelGUI.add(textRecipientCity);mainPanelGUI.add(tfRecipientCity);
        mainPanelGUI.add(textRecipientAddress);mainPanelGUI.add(tfRecipientAddress);
        mainPanelGUI.add(textRecipientState);mainPanelGUI.add(tfRecipientState);
        mainPanelGUI.add(textRecipientZip);mainPanelGUI.add(tfRecipientZip);
        frame.add(BorderLayout.CENTER,s1);
        frame.add(BorderLayout.NORTH,costPanel);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        if (s.equals("set cost")) {
            packageCost= Double.parseDouble(tfShippingCost.getText());
            System.out.println("cost per ounce updated: "+packageCost);
        }
        packageTypeSelect = cbShippingType.getSelectedIndex();
        if(s.equals("Add package")){
            packsCount++;
            if(packsCount>1){
                taOutput.append("\n\n");
            }
            double calcWeight = Double.parseDouble(tfPackWeight.getText());

            Person sender = new Person(tfSenderName.getText(),tfSenderAddress.getText(),tfSenderCity.getText(),tfSenderState.getText(),tfSenderZip.getText()); //creates Person with constructor, "sender" and "recipient" then passes those to Package below.
            Person recipient = new Person(tfRecipientName.getText(),tfRecipientAddress.getText(),tfRecipientCity.getText(),tfRecipientState.getText(),tfRecipientZip.getText());

            switch (packageTypeSelect) {
                case 0 -> {
                    Package packsAdd = new Package(sender.Name, sender.Address, sender.City, sender.State, sender.ZIP,
                            recipient.Name, recipient.Address, recipient.City, recipient.State, recipient.ZIP,
                            calcWeight, packageCost);
                    outPackageCost.setText(String.valueOf(packsAdd.totalcost));
                    System.out.println(packsAdd);
                    calcCostVec.add(packsAdd.totalcost);
                    taOutput.append(packsAdd.toString());
                }
                case 1 -> {
                    TwoDayPackage packsTwoDay = new TwoDayPackage(sender.Name, sender.Address, sender.City, sender.State, sender.ZIP,
                            recipient.Name, recipient.Address, recipient.City, recipient.State, recipient.ZIP,
                            calcWeight, packageCost, flatFee);
                    System.out.println(packsTwoDay);
                    calcCostVec.add(packsTwoDay.totalcost);
                    outPackageCost.setText(String.valueOf(packsTwoDay.totalcost));
                    taOutput.append(packsTwoDay.toString());
                }
                case 2 -> {
                    OvernightPackage packOvernight = new OvernightPackage(sender.Name, sender.Address, sender.City, sender.State, sender.ZIP,
                            recipient.Name, recipient.Address, recipient.City, recipient.State, recipient.ZIP,
                            calcWeight, packageCost, additionalOvernight);
                    System.out.println(packOvernight);
                    outPackageCost.setText(String.valueOf(packOvernight.totalcost));
                    calcCostVec.add(packOvernight.totalcost);
                    taOutput.append(packOvernight.toString());
                }
            }

            tfSenderName.setText(""); tfSenderAddress.setText("");tfSenderCity.setText("");tfSenderState.setText("");tfSenderZip.setText("");
            tfPackWeight.setText("");
            tfRecipientName.setText("");tfRecipientAddress.setText("");tfRecipientCity.setText("");tfRecipientState.setText("");tfRecipientZip.setText("");
        }

    }
    public static void main(String[] args) {
        packageWindow();
    }
}


