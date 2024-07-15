package Hotel.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
    private static final String url = "jdbc:mysql://localhost:3306/hotelmanagement";
    private static final String username = "root";
    private static final String paasword = "amit2108";
    Connection c;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Loading the MySQL Driver

            // Establishing the Connection
            this.c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement", "root", "amit2108");

            this.s = this.c.createStatement();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

        public static void main(String[] args) {
            Conn conn = new Conn();
            if (conn.c != null) {
                System.out.println("Connection successful!");
            } else {
                System.out.println("Connection failed.");
            }
        }
    }

