package com.Lei;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static com.Lei.Main.calcCostVec;
import static com.Lei.Main.total;

public class MainGUI extends JFrame implements ActionListener {
    MainGUI(){}
    static JTextField tfShippingCost,outPackageCost,tfPackWeight,tfSumPackages;
    double packageCost = 100d;
    static int packageTypeSelect, packsCount;
    double flatFee =200;
    double additionalOvernight = 100;
    static JButton addPackButton;
    static JTextField tfSenderName, tfSenderAddress, tfSenderCity, tfSenderState, tfSenderZip;
    static JTextField tfRecipientName, tfRecipientAddress, tfRecipientCity, tfRecipientState, tfRecipientZip;
    static JPanel outputListPanel;
    static JComboBox cbShippingType;
    static JTextArea taOutput;

    public static void main() {
        MainGUI mainGUI = new MainGUI();
        mainGUI.setLayout(null);
        JFrame frame = new JFrame("Shipping cost calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(780, 390);
        JPanel mainPanelGUI = new JPanel();
        mainPanelGUI.setLayout(null);
        outputListPanel = new JPanel();
        JSplitPane s1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, mainPanelGUI,outputListPanel);
        s1.setOrientation(SwingConstants.VERTICAL);
        mainPanelGUI.setMinimumSize(new Dimension(410,390));

        s1.setDividerLocation(frame.getWidth()/2-25);
        taOutput = new JTextArea();
        JLabel outputLabel = new JLabel("Package List: ");
        JLabel sumPackagesLabel = new JLabel("Sum of all packages: ");
        tfSumPackages = new JTextField("");
        taOutput.setEditable(false);
        taOutput.setLineWrap(true);
        taOutput.setWrapStyleWord(true);
        JScrollBar outputScrollBar = new JScrollBar();
        JScrollPane scrollPackageList = new JScrollPane(taOutput);
        scrollPackageList.add(outputScrollBar);
        scrollPackageList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPackageList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPackageList.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        scrollPackageList.setMinimumSize(new Dimension(380, 280));
        scrollPackageList.setPreferredSize(new Dimension(380, 280));
        outputLabel.setBounds(20,0,100,20);
        sumPackagesLabel.setBounds(400,325,150,20);
        tfSumPackages.setBounds(520,325,150,20);
        tfSumPackages.setEditable(false);
        scrollPackageList.add(outputLabel);
        outputListPanel.add(scrollPackageList);
        JPanel costPanel = new JPanel();


        JLabel textCost = new JLabel("cost per ounce:");
        tfShippingCost = new JTextField("100",10);
        JButton costSet = new JButton("set cost");
        String[] shippingType = {"Standard", "Two-day", "Overnight"};
        JLabel labelShippingType = new JLabel("Select shipping:");
        cbShippingType = new JComboBox(shippingType);
        cbShippingType.setBounds(100,5,130,20);
        labelShippingType.setBounds(5,5,100,20);

        JLabel labelWeight = new JLabel("Weight:");
        JLabel textPackageCost = new JLabel("Shipping fee:");
        addPackButton = new JButton("Add package");
        tfPackWeight = new JFormattedTextField();
        labelWeight.setBounds(5, 30,100,20);
        tfPackWeight.setBounds(100,30,50,20);
        outPackageCost = new JTextField("",7);
        outPackageCost.setEditable(false);
        addPackButton.addActionListener(mainGUI);
        addPackButton.setSize(100,20);

        JLabel textSender = new JLabel("Sender:");
        JLabel textSenderName = new JLabel("Name: ");
        JLabel textSenderAddress = new JLabel("Address: ");
        JLabel textSenderCity = new JLabel("City: ");
        JLabel textSenderState = new JLabel("State: ");
        JLabel textSenderZip = new JLabel("Zip Code: ");

        textSender.setBounds(5,50,150,20);

        tfSenderName = new JTextField("");
        textSenderName.setBounds(5,70,150,20);
        tfSenderName.setBounds(100,70,250,20);

        tfSenderAddress = new JTextField("");
        textSenderAddress.setBounds(5,90,150,20);
        tfSenderAddress.setBounds(100,90,250,20);

        tfSenderCity = new JTextField("");
        textSenderCity.setBounds(5,110,150,20);
        tfSenderCity.setBounds(100,110,250,20);

        tfSenderState = new JTextField("");
        textSenderState.setBounds(5,130,150,20);
        tfSenderState.setBounds(100,130,250,20);

        tfSenderZip = new JTextField("");
        textSenderZip.setBounds(5,150,150,20);
        tfSenderZip.setBounds(100,150,250,20);

        JLabel textRecipient = new JLabel("Recipient:");
        JLabel textRecipientName = new JLabel("Name: ");
        JLabel textRecipientAddress = new JLabel("Address: ");
        JLabel textRecipientCity = new JLabel("City: ");
        JLabel textRecipientState = new JLabel("State: ");
        JLabel textRecipientZip = new JLabel("Zip Code: ");

        textRecipient.setBounds(5,170,150,20);

        tfRecipientName = new JTextField("");
        textRecipientName.setBounds(5,190,150,20);
        tfRecipientName.setBounds(100,190,250,20);

        tfRecipientAddress = new JTextField("");
        textRecipientAddress.setBounds(5,210,150,20);
        tfRecipientAddress.setBounds(100,210,250,20);

        tfRecipientCity = new JTextField("");
        textRecipientCity.setBounds(5,230,150,20);
        tfRecipientCity.setBounds(100,230,250,20);

        tfRecipientState = new JTextField("");
        textRecipientState.setBounds(5,250,150,20);
        tfRecipientState.setBounds(100,250,250,20);

        tfRecipientZip = new JTextField("");
        textRecipientZip.setBounds(5,270,150,20);
        tfRecipientZip.setBounds(100,270,250,20);

        costPanel.add(addPackButton);costPanel.add(textPackageCost);costPanel.add(outPackageCost);
        costPanel.add(textCost);costPanel.add(tfShippingCost);costPanel.add(costSet);
        frame.add(sumPackagesLabel);frame.add(tfSumPackages);

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
                taOutput.append("\n\n\n");
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
                    tfSumPackages.setText((String) total());
                }
                case 1 -> {
                    TwoDayPackage packsTwoDay = new TwoDayPackage(sender.Name, sender.Address, sender.City, sender.State, sender.ZIP,
                            recipient.Name, recipient.Address, recipient.City, recipient.State, recipient.ZIP,
                            calcWeight, packageCost, flatFee);
                    System.out.println(packsTwoDay);
                    calcCostVec.add(packsTwoDay.totalcost);
                    outPackageCost.setText(String.valueOf(packsTwoDay.totalcost));
                    taOutput.append(packsTwoDay.toString());
                    tfSumPackages.setText((String) total());
                }
                case 2 -> {
                    OvernightPackage packOvernight = new OvernightPackage(sender.Name, sender.Address, sender.City, sender.State, sender.ZIP,
                            recipient.Name, recipient.Address, recipient.City, recipient.State, recipient.ZIP,
                            calcWeight, packageCost, additionalOvernight);
                    System.out.println(packOvernight);
                    outPackageCost.setText(String.valueOf(packOvernight.totalcost));
                    calcCostVec.add(packOvernight.totalcost);
                    taOutput.append(packOvernight.toString());
                    tfSumPackages.setText((String) total());
                }
            }

            tfSenderName.setText(""); tfSenderAddress.setText("");tfSenderCity.setText("");tfSenderState.setText("");tfSenderZip.setText("");
            tfPackWeight.setText("");
            tfRecipientName.setText("");tfRecipientAddress.setText("");tfRecipientCity.setText("");tfRecipientState.setText("");tfRecipientZip.setText("");
        }

    }
}


