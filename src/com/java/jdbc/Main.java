package com.java.jdbc;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

      Class.forName("com.mysql.cj.jdbc.Driver");

      Connection connection=DriverManager.getConnection("","","");

      Statement statement=connection.createStatement();
      statement.execute(" CREATE TABLE queries");
      statement.executeUpdate("INSERT,UPDATE,DELETE queries");
      statement.executeQuery("GET OR FETCH OR SELECT queries");

      ResultSet resultSet= statement.getResultSet();
      resultSet.next();
      connection.close();

    }
}