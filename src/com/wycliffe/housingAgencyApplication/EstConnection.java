package com.wycliffe.housingAgencyApplication;
//@author Wycliffe.Ochieng

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class EstConnection {
    Connection con;
    ResultSet rs;
    Statement st;
    PreparedStatement pst;
    String SQLTenants = "select * from customers";
    String AgentUpdate = "update users set username = ?, password = ? WHERE username = 'wycliffe'";
    String UpDateTenants = "";
    String url = "jdbc:mysql://localhost/housing?autoReconnect=true&useSSL=true";
    String user="root";
    String password ="prof1989*";
    int xMouse,yMouse;
    EstConnection(){
        
        try{
          con = DriverManager.getConnection(url,user,password); 
          
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    
    }
}
