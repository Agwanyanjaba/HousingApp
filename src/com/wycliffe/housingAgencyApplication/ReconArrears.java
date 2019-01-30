//
package com.wycliffe.housingAgencyApplication;

//@author Wycliffe.Ochieng

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ReconArrears {
String SQLRecon; //= "select customer_id,sum(arrears) from payments group by customer_id";
ResultSet rsRecon;
Statement stRecon;

public void recon(){
   
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/housing?useSSL=true","root","prof1989*");
        stRecon = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String CustomerID="";
        SQLRecon = "select sum(Arrears) from payments where customer_id ='"+CustomerID+"'";
        rsRecon = stRecon.executeQuery(SQLRecon);
        String ArreasAmt = rsRecon.getString("sum(arrears)");
        System.out.println(ArreasAmt);
        stRecon.executeQuery("Update customers set Total_Arrears = '"+ArreasAmt+"' where customer_id ='"+CustomerID+"'");
           
        JOptionPane.showMessageDialog(null, "Payment Added successfully","Rent Payment Success",JOptionPane.INFORMATION_MESSAGE);
        
           
       
        }
        catch(ClassNotFoundException |SQLException e){
            e.printStackTrace();
        }
        
}
    public static void main(String [] args){
        ReconArrears reconObj = new ReconArrears();
        reconObj.recon();
    }
}
