package com.kal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.Document;


public class FirstGUI extends JFrame implements ActionListener{
    static JTextArea ta;
    static JTextField tf;
    static JTextField chat;
    static JButton send;
    static JFrame frame;
    FirstGUI (){

    }
    //Creating the panel at bottom and adding components
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creating the Frame
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        FirstGUI te = new FirstGUI();
        send.addActionListener(te);
        reset.addActionListener(te);
        tf = new JTextField("",16); // accepts up to 20 characters
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        panel.add(reset);
        // Text Area at the Center
        ta = new JTextArea();
        ta.setEditable(false);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);


        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.show();
    }
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("Send")) {
            // set the text of the label to the text of the field
            ta.append("you: "+tf.getText()+"\n");

            // set the text of field to blank
            tf.setText("");
        }
        if(s.equals("Reset")){
            ta.setText("");
        }
    }
}

