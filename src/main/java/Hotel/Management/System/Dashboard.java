package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    Dashboard(){
        setLayout(null);
        setBounds(0,0,1550,1000);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);

        JLabel text = new JLabel("THE OBEROI WELCOMES YOU");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("tahoma",Font.PLAIN,46));
        text.setForeground(Color.white);
        image.add(text);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);

        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        mb.add(hotel);

        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);


        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);

        JMenuItem employee = new JMenuItem("ADD EMPLOYEE");
        employee.addActionListener(this);
        admin.add(employee);

        JMenuItem rooms = new JMenuItem("ADD ROOMS");
        rooms.addActionListener(this);
        admin.add(rooms);

        JMenuItem driver = new JMenuItem("ADD DRIVER");
        driver.addActionListener(this);
        admin.add(driver);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
        }else if (ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms();
        }else if (ae.getActionCommand().equals("ADD DRIVER")) {
            new AddDriver();
          }else if (ae.getActionCommand().equals("RECEPTION")) {
            new Reception();
        }
        }


    public static void main(String[] args){
        new Dashboard();
    }
}
