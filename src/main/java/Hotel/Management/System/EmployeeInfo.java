package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener {

    JTable table;
    JButton back;
    EmployeeInfo(){
        getContentPane().setBackground(Color.white);
        setLayout(null);


        JLabel l1 = new JLabel("NAME");
        l1.setBounds(40,10,100,20);
        add(l1);

        JLabel l2 = new JLabel("AGE");
        l2.setBounds(140,10,100,20);
        add(l2);

        JLabel l3 = new JLabel("GENDER");
        l3.setBounds(260,10,100,20);
        add(l3);

        JLabel l4 = new JLabel("DESIGNATION");
        l4.setBounds(400,10,100,20);
        add(l4);

        JLabel l5 = new JLabel("SALARY");
        l5.setBounds(540,10,100,20);
        add(l5);

        JLabel l6 = new JLabel("PHONE");
        l6.setBounds(670,10,100,20);
        add(l6);

        JLabel l7 = new JLabel("EMAIL");
        l7.setBounds(790,10,100,20);
        add(l7);

        JLabel l8 = new JLabel("AADHAR");
        l8.setBounds(910,10,100,20);
        add(l8);

        table = new JTable();
        table.setBounds(0,40,1000,400);
        add(table);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("Select * from employee");

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
        new EmployeeInfo();
    }
}
