package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import model.ContactUs;

public class ContactUsDaoImpl
{
  final String SAVE_QUERY = "insert into contactus values(?,?,?,?,?)";
  
  public ContactUsDaoImpl() {}
  
  public boolean saveContactUS(ContactUs contact) throws Exception { Timestamp t = new Timestamp(new java.util.Date().getTime());
    
    Connection con = util.DBConnection.getConnection();
    PreparedStatement pst = con.prepareStatement("insert into contactus values(?,?,?,?,?)");
    pst.setString(1, contact.getName());
    pst.setString(2, contact.getPhnumber());
    pst.setString(3, contact.getCity());
    pst.setString(4, contact.getSubject());
    pst.setTimestamp(5, t);
    pst.executeUpdate();
    
    return true;
  }
}