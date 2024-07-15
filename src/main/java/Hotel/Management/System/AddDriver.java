package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener {

    JButton add , cancel;
    JTextField tfname,tfage,tfcompany,tfmodel,tflocation;

    JComboBox availableCombo,genderCombo,typeCombo;
    AddDriver(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("ADD Drivers");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 10, 200, 20);
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblname.setBounds(60, 70, 120, 30);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,70,150,30);
        add(tfname);

        JLabel lblage = new JLabel("Age");
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblage.setBounds(60, 110, 120, 30);
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200,110,150,30);
        add(tfage);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblgender.setBounds(60, 150, 120, 30);
        add(lblgender);

        String ageOptions[]={"Male","Female"};
        genderCombo = new JComboBox(ageOptions);
        genderCombo.setBounds(200,150,150,30);
        genderCombo.setBackground(Color.white);
        add(genderCombo);

        JLabel lblcom = new JLabel("Car Company");
        lblcom.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblcom.setBounds(60, 190, 120, 30);
        add(lblcom);

        tfcompany = new JTextField();
        tfcompany.setBounds(200,190,150,30);
        add(tfcompany);

        JLabel lblmodel = new JLabel("Car Model");
        lblmodel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblmodel.setBounds(60, 230, 120, 30);
        add(lblmodel);

        tfmodel = new JTextField();
        tfmodel.setBounds(200,230,150,30);
        add(tfmodel);

        JLabel lblavailable = new JLabel("Availability");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblavailable.setBounds(60, 270, 120, 30);
        add(lblavailable);

        String driverOptions[]={"Available","Busy"};
        availableCombo = new JComboBox(driverOptions);
        availableCombo.setBounds(200,270,150,30);
        availableCombo.setBackground(Color.white);
        add(availableCombo);

        JLabel lbllocation = new JLabel("Location");
        lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbllocation.setBounds(60, 310, 120, 30);
        add(lbllocation);

        tflocation = new JTextField();
        tflocation.setBounds(200,310,150,30);
        add(tflocation);

        add = new JButton("Add Driver");
        add.addActionListener(this);
        add.setBounds(60, 370, 130, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        cancel.setBounds(220, 370, 130, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);

        setBounds(300, 200, 980, 470);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String) genderCombo.getSelectedItem();
            String company = tfcompany.getText();
            String brand = tfmodel.getText();
            String available = (String) availableCombo.getSelectedItem();
            String location = tflocation.getText();

            try {
                Conn conn = new Conn();
                String query = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";

                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"New Driver Added Sucesfully");

            }catch (Exception e){
                e.printStackTrace();
            }

        }else if (ae.getSource() == cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new AddDriver();
    }
}
