package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
//import java.sql.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {

    JComboBox comboid;
    JTextField tfnumber , tfname , tfgender , tfcountry , tfdeposit;
    JRadioButton rmale , rfemale ;
    Choice croom;
    JLabel checkintime;

    JButton add , back;

    AddCustomer(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel lbltext = new JLabel("ADD CUSTOMER");
        lbltext.setBounds(100,20,300,30);
        lbltext.setFont(new Font("Raleway",Font.BOLD,20));
        add(lbltext);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(35,80,100,20);
        lblid.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblid);

        String idOptions[]={"Aadhar","Pan-Card","Paasport","Driving License","Voter Id"};
        comboid = new JComboBox(idOptions);
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.white);
        add(comboid);

        JLabel lbnumber = new JLabel("Number");
        lbnumber.setBounds(35,120,100,20);
        lbnumber.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);

        JLabel lbname = new JLabel("Name");
        lbname.setBounds(35,160,100,20);
        lbname.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbname);

        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);

        JLabel lbgender = new JLabel("Gender");
        lbgender.setBounds(35,200,100,20);
        lbgender.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbgender);

        rmale = new JRadioButton("Male");
        rmale.setBounds(200,200,60,25);
        rmale.setBackground(Color.white);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(270,200,80,25);
        rfemale.setBackground(Color.white);
        add(rfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

        JLabel lbcountry = new JLabel("Country");
        lbcountry.setBounds(35,240,100,20);
        lbcountry.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(35,280,150,20);
        lblroom.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblroom);

        // Retriveing Data from db
        croom = new Choice();
        try {
            Conn c = new Conn();

            String query = "select * from room where availability = 'Available' ";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()){
                croom.add(rs.getString("roomnumber"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        croom.setBounds(200,280,150,25);
        add(croom);


        Date date = new Date();

        JLabel lbltime = new JLabel("CheckIn Time ");
        lbltime.setBounds(35,320,150,20);
        lbltime.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbltime);

        checkintime = new JLabel(""+date);
        checkintime.setBounds(200,320,150,25);
        checkintime.setFont(new Font("Raleway",Font.PLAIN,15));
        add(checkintime);


        JLabel lbdeposit = new JLabel("Deposit");
        lbdeposit.setBounds(35,360,100,20);
        lbdeposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbdeposit);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);


        add = new JButton("ADD");
        add.setBounds(50,410,120,30);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(200,410,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);

        setBounds(350,200,800,550);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;

            if(rmale.isSelected()){
                gender = "Male";
            }else {
                gender = "Female";
            }

            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposit = tfdeposit.getText();

            try {
                Conn conn = new Conn();
                String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String query2 = "update room set availability = 'Occupied' where roomnumber = '"+room+"'";
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Customer Added Sucessfully");

                setVisible(false);
                new Reception();

            }catch (Exception e){
                e.printStackTrace();
            }


        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }


public static void main(String[] args) {
        new AddCustomer();
    }
}