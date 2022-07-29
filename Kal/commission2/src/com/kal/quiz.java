
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class quiz extends JFrame implements ActionListener {
    static JButton button0 = new JButton();
    static JButton button1 = new JButton();
    static JButton button2 = new JButton();
    static JButton button3 = new JButton();
    public static void main(String s[]) {
        quiz gui = new quiz();
        JFrame frame = new JFrame("QUIZ.COM");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel quiz = new JLabel();
        quiz.setText("QUIZ.COM\n");
        quiz.setHorizontalAlignment(JLabel.CENTER);
        JTextArea question = new JTextArea();
        question.setText("Who is the new president of the Philippines?");
        question.setEditable(false);

        button0.setText("A. Secretary Mar Roxas");
        button1.setText("B. Mayor Rodrigo Duterte");
        button2.setText("C. Sen. Miriam Santiago");
        button3.setText("D. Sen. Grace Poe");
        quiz.setBackground(Color.red);
        quiz.setOpaque(true);
        button0.setPreferredSize(new Dimension(300,20));
        button1.setPreferredSize(new Dimension(300,20));
        button2.setPreferredSize(new Dimension(300,20));
        button3.setPreferredSize(new Dimension(300,20));
        frame.add(BorderLayout.NORTH,quiz);
        button0.setBackground(new Color(204, 162, 0));
        button1.setBackground(new Color(204, 162, 0));
        button2.setBackground(new Color(204, 162, 0));
        button3.setBackground(new Color(204, 162, 0));
        button0.addActionListener(gui);
        button1.addActionListener(gui);
        button2.addActionListener(gui);
        button3.addActionListener(gui);
        panel.add(question);
        panel.add(button0);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        frame.add(panel);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        if(s.equals("B. Mayor Rodrigo Duterte")){
            button0.setBackground(new Color(204, 162, 0));
            button1.setBackground(Color.white);
            button1.setForeground(Color.black);
            button2.setBackground(new Color(204, 162, 0));
            button3.setBackground(new Color(204, 162, 0));
        }else {
            button0.setBackground(Color.red);
            button1.setBackground(Color.red);
            button2.setBackground(Color.red);
            button3.setBackground(Color.red);
        }
    }
}