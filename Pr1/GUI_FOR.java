// import java.awt.*;
// import java.awt.event.*;
// import javax.swing.*;

// public class GUI_FOR extends JFrame {
//     private JButton button1 = new JButton("Задача 2");
//     private JTextField input1 = new JTextField("", 5);
//     private JButton button2 = new JButton("Задача 7");
//     private JTextField input2 = new JTextField("", 5);
//     private JButton button3 = new JButton("Задача 12");
//     private JTextField input3 = new JTextField("", 5);
//     private JButton button4 = new JButton("Задача 17");
//     private JTextField input4 = new JTextField("", 5);
//     private JButton button5 = new JButton("Задача 27");
//     private JTextField input5 = new JTextField("", 5);

//     public GUI_FOR() {
//         super("Задачи");
//         this.setBounds(100,100,300,200);
//         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//         Container container = this.getContentPane();
//         container.setLayout(new GridLayout(5,1,2,2));
//         container.add(button1);
//         container.add(button2);
//         container.add(button3);
//         container.add(button4);
//         container.add(button5);

//         button1.addActionListener(new ButtonEventListener());
//         button2.addActionListener(new ButtonEventListener());
//         button3.addActionListener(new ButtonEventListener());
//         button4.addActionListener(new ButtonEventListener());
//         button5.addActionListener(new ButtonEventListener());
//     }

//     class ButtonEventListener implements ActionListener {
//         public void actionPerformed(ActionEvent e) {
//             String message = "aaaa";
//             message += "Button clicked: " + e.getActionCommand() + "; ";
        

//         }
//     }
// }
