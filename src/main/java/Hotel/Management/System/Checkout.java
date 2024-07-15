package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.sql.ResultSet;

public class Checkout extends JFrame implements ActionListener {

    Choice ccustomer;
    JLabel lblroomnumber, lblcheckintime, lblcheckouttime;
    JButton checkout, back;

    Checkout() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("CHECKOUT");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(100, 20, 100, 30);
        text.setForeground(Color.blue);
        add(text);

        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30, 80, 100, 30);
        add(lblid);

        ccustomer = new Choice();
        ccustomer.setBounds(150, 80, 150, 30);
        add(ccustomer);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(310, 80, 20, 20);
        add(image);

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 130, 100, 30);
        add(lblroom);

        lblroomnumber = new JLabel();
        lblroomnumber.setBounds(150, 130, 100, 30);
        add(lblroomnumber);

        JLabel lblcheckin = new JLabel("CheckIN Time");
        lblcheckin.setBounds(30, 180, 100, 30);
        add(lblcheckin);

        lblcheckintime = new JLabel();
        lblcheckintime.setBounds(150, 180, 100, 30);
        add(lblcheckintime);

        JLabel lblcheckout = new JLabel("CheckOut Time");
        lblcheckout.setBounds(30, 230, 100, 30);
        add(lblcheckout);

        lblcheckouttime = new JLabel();
        lblcheckouttime.setBounds(150, 230, 150, 30);
        add(lblcheckouttime);

        Date date = new Date();
        lblcheckouttime.setText("" + date);

        checkout = new JButton("Check Out");
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.setBounds(30, 280, 120, 30);
        checkout.addActionListener(this);
        add(checkout);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(170, 280, 120, 30);
        back.addActionListener(this);
        add(back);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while (rs.next()) {
                ccustomer.add(rs.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ccustomer.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                updateCustomerDetails();
            }
        });

        // Initial update for the first selected customer
        updateCustomerDetails();

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(350, 50, 400, 250);
        add(image1);

        setBounds(300, 200, 800, 400);
        setVisible(true);
    }

    public void updateCustomerDetails() {
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer where number = '" + ccustomer.getSelectedItem() + "'");
            if (rs.next()) {
                lblroomnumber.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkintime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkout) {
            String query1 = "delete from customer where number = '" + ccustomer.getSelectedItem() + "'";
            String query2 = "update room set availability = 'Available' where roomnumber = '" + lblroomnumber.getText() + "'";

            try {
                Conn conn = new Conn();
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Checkout Done");
                setVisible(false);
                new Reception();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new Checkout();
    }
}
