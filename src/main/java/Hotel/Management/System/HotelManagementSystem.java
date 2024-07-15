package Hotel.Management.System;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementSystem extends JFrame implements ActionListener {

    HotelManagementSystem(){
//        setSize(1366 , 600);
//        setLocation(100 ,100);
        setBounds(0,0,1666,830);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1666,830);
        add(image);

        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(700,450 ,1200,50);
        text.setForeground(Color.blue);
        text.setFont(new Font("serif",Font.PLAIN,50));
        image.add(text);

        JButton next = new JButton("NEXT");
        next.setBounds(1000,520,140,50);
        next.setBackground(Color.white);
        next.setForeground(Color.black);
        next.addActionListener(this);
        next.setFont(new Font("serif",Font.PLAIN,20));
        image.add(next);

        setVisible(true);

//        FOR  BLINKING THE TEXT
        while (true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }

            text.setVisible(true);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new HotelManagementSystem();

    }
}