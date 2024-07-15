package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {

    JTable table;
    JButton back;
    CustomerInfo(){
        getContentPane().setBackground(Color.white);
        setLayout(null);


        JLabel l1 = new JLabel("DOCUMENT TYPE");
        l1.setBounds(10,10,130,20);
        add(l1);

        JLabel l2 = new JLabel("NUMBER");
        l2.setBounds(160,10,100,20);
        add(l2);

        JLabel l3 = new JLabel("NAME");
        l3.setBounds(290,10,100,20);
        add(l3);

        JLabel l4 = new JLabel("GENDER");
        l4.setBounds(420,10,100,20);
        add(l4);

        JLabel l5 = new JLabel("COUNTRY");
        l5.setBounds(540,10,100,20);
        add(l5);

        JLabel l6 = new JLabel("ROOM NUMBER");
        l6.setBounds(640,10,100,20);
        add(l6);

        JLabel l7 = new JLabel("CHECKIN TIME");
        l7.setBounds(770,10,100,20);
        add(l7);

        JLabel l8 = new JLabel("DEPOSIT");
        l8.setBounds(900,10,100,20);
        add(l8);

        table = new JTable();
        table.setBounds(0,40,1000,400);
        add(table);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("Select * from customer");

            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            e.printStackTrace();
        }

        back = new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(420,500,120,20);
        back.addActionListener(this);
        add(back);

        setBounds(300,200,1000,600);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }


    public static void main(String[] args) {
        new CustomerInfo();
    }
}

