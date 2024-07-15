package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField username ;
    JPasswordField paasword;
    JButton login , cancel;
    Login(){
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(500,200,600,450);

        JLabel user = new JLabel("USERNAME:");
        user.setBounds(50,40,100,30);
        add(user);

        username = new JTextField();
        username.setBounds(160,40,150,30);
        add(username);

        JLabel paas = new JLabel("PAASWORD:");
        paas.setBounds(50,100,100,50);
        add(paas);

        paasword = new JPasswordField();
        paasword.setBounds(160,110,150,30);
        add(paasword);

        login = new JButton("LOGIN");
        login.setBounds(60,190,90,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("CANCEL");
        cancel.setBounds(205,190,90,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,20,200,200);
        add(image);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae ){
        if (ae.getSource() == login){
               String user = username.getText();
               String paas = paasword.getText();

               try {
                   Conn c = new Conn();
                   String query = "Select * from login where username = '" + user + "' and paasword = '" + paas + "'";

                   ResultSet rs = c.s.executeQuery(query);

                   if (rs.next()){
                       setVisible(false);
                       new Dashboard();
                   }else {
                       JOptionPane.showMessageDialog(null,"Invalid UserName & Paasword");
//                       setVisible(false);
                   }

               }
               catch(Exception e){
                   e.printStackTrace();
               }

        }
        else if(ae.getSource() == cancel)
        {
            setVisible(false);
        }
    }

    public static void main(String[] args){

        new Login();
    }
}
