package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Pickup extends JFrame implements ActionListener {

    JTable table;
    JButton back, submit;
    Choice typeOfCar;
    JCheckBox available;

    Pickup() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("PICKUP SERVICE");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(400, 30, 200, 30);
        add(text);

        JLabel lblbed = new JLabel("Type Of Car");
        lblbed.setBounds(50, 100, 100, 20);
        add(lblbed);

        typeOfCar = new Choice();
        typeOfCar.setBounds(150,100,200,25);
        add(typeOfCar);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from driver");

            while (rs.next()){
                typeOfCar.add(rs.getString("brand"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        available = new JCheckBox("Only display Available");
        available.setBounds(650, 100, 200, 25);
        available.setBackground(Color.white);
        add(available);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(30, 160, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(200, 160, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(330, 160, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Company");
        l4.setBounds(460, 160, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Brand");
        l5.setBounds(630, 160, 100, 20);
        add(l5);

        JLabel l6 = new JLabel("Availability");
        l6.setBounds(740, 160, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("Loction");
        l7.setBounds(890, 160, 100, 20);
        add(l7);

        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("Select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(300, 520, 120, 30);
        submit.addActionListener(this);
        add(submit);

        back = new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(500, 520, 120, 30);
        back.addActionListener(this);
        add(back);

        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                String query1 = "select * from driver where brand = '" + typeOfCar.getSelectedItem() + "'";

                Conn conn = new Conn();
                ResultSet rs ;

                rs = conn.s.executeQuery(query1);

                table.setModel(DbUtils.resultSetToTableModel(rs));


            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new Pickup();
    }
}
