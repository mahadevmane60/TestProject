
package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import util.DBConnection;

public class ContactUsDaoImpl {
   final String SAVE_QUERY = "insert into contactus values(?,?,?,?,?)";
   
   public boolean saveContactUS(model.ContactUs contact) throws Exception {
       
       Timestamp t= new Timestamp(new java.util.Date().getTime());
       
       Connection con = DBConnection.getConnection();
       PreparedStatement pst = con.prepareStatement(SAVE_QUERY);
       pst.setString(1,contact.getName());
       pst.setString(2,contact.getPhnumber());
       pst.setString(3,contact.getCity());
       pst.setString(4,contact.getSubject());
       pst.setTimestamp(5,t);       
       pst.executeUpdate();          
     return true;
    }
    
}
