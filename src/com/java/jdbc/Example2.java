package com.java.jdbc;

import java.sql.*;

public class Example2 {
    public static final String CREATE_LAPTOP_TABLE= """
            CREATE TABLE laptops(
              id INT NOT NULL AUTO_INCREMENT,
              brand VARCHAR(50) NOT NULL,
              model VARCHAR(50) NOT NULL,
              price DECIMAL(10, 2),
              storage INT,
              PRIMARY KEY (id)
            );
            """;
    public static final String UPDATE_LAPTOP_DATA= """
            UPDATE laptops SET brand =?        
            """;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","password");

        Statement statement=connection.createStatement();
      //  statement.execute(CREATE_LAPTOP_TABLE);

        PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_LAPTOP_DATA);
        preparedStatement.setInt(1,1);
        preparedStatement.setString(2,"Samsung");
        preparedStatement.setString(3,"Galaxy S21");
        preparedStatement.setDouble(4,300);
        preparedStatement.setInt(5,200);
        int rowsAffected=preparedStatement.executeUpdate();
        System.out.println(rowsAffected);
    }
}
