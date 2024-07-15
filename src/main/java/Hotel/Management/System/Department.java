package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener {

    JTable table;
    JButton back;
    Department(){
        getContentPane().setBackground(Color.white);
        setLayout(null);


        JLabel l1 = new JLabel("Department");
        l1.setBounds(10,10,100,20);
        add(l1);

        JLabel l2 = new JLabel("Budget");
        l2.setBounds(420,10,100,20);
        add(l2);

        table = new JTable();
        table.setBounds(0,40,700,300);
        add(table);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("Select * from Department");

            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            e.printStackTrace();
        }

        back = new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(280,400,120,20);
        back.addActionListener(this);
        add(back);

        setBounds(400,200,700,480);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }


    public static void main(String[] args) {
        new Department();
    }
}
