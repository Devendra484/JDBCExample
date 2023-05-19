package com.java.jdbc;

import java.sql.*;

public class Example1 {

    public static final String CREATE_MOBILE_TABLE= """
            CREATE TABLE mobile_phones (
              id INT NOT NULL AUTO_INCREMENT,
              brand VARCHAR(50) NOT NULL,
              model VARCHAR(50) NOT NULL,
              price DECIMAL(10, 2),
              storage INT,
              PRIMARY KEY (id)
            );
            """;
    public static final String INSERT_MOBILE_DATA= """
            INSERT INTO mobile_phones (brand, model, price, storage)
            VALUES ('Samsung', 'Galaxy S21', 1099.99, 128),
                   ('Apple', 'iPhone 12', 999.99, 256),
                   ('Google', 'Pixel 5', 699.99, 128),
                   ('OnePlus', '8T', 749.99, 256);
            """;

    public  static  final  String UPDATE_MOBILE_DATA= """
            UPDATE mobile_phones
            SET price = 799.99
            WHERE brand = 'Google' AND model = 'Pixel 5';
            """;
    public  static  final  String DELETE_MOBILE_DATA= """
            DELETE FROM mobile_phones
            WHERE brand = 'OnePlus' AND model = '8T';
            """;
    public static  final  String SELECT_MOBILE_DATA= """
            SELECT * FROM mobile_phones
            """;


    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("com.mysql.cj.jdbc.Driver");  //1 Registering the Driver

        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","password");
                                                            //2.Connecting to Database (URL,UserName,Password)

        Statement statement=connection.createStatement();  //3.Creating the statement

        //statement.execute(CREATE_MOBILE_TABLE);            //4.CREATE query using execute method and create table

        //statement.executeUpdate(INSERT_MOBILE_DATA);              //5.INSERT  query using executeUpdate method to insert data


        //statement.executeUpdate(UPDATE_MOBILE_DATA);       //6.UPDATE query using executeUpdate method to update data

        //statement.executeUpdate(DELETE_MOBILE_DATA);    //7.DELETE query using executeUpdate method to delete data

         ResultSet resultSet=statement.executeQuery(SELECT_MOBILE_DATA);               //7.SELECT query using executeQuery method to select/fetch data

        while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+" "+ resultSet.getString(2)+" "+ resultSet.getString(3)+" "+ resultSet.getInt(4)+" "+ resultSet.getInt(5));
        }                                                          //8.traversing through the data using resultSet and next()

     //   String UPDATE_MOBILE_PRICE="UPDATE mobile_phones SET price=? WHERE id=?";            //9.Dynamic Query
       // PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_MOBILE_PRICE); //10.prepared statement.

       // preparedStatement.setDouble(1,30000.00);
       // preparedStatement.setInt(2,1);
       // int rowsAffected= preparedStatement.executeUpdate();
        connection.close();                                        //9.closing the connection


    }
}
