package com.registration.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
        private static Connection connection;

        public static Connection getConnection(){
            try {
                if (connection == null){

                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/javaproject", "root", "123456");
                    System.out.println("successfull");
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return connection;
        }

}
