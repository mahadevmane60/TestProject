package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import model.User;
import org.apache.log4j.Logger;
import util.DBConnection;

public class UserDaoImpl implements UserDao
{
  Connection con = null;
  PreparedStatement pst = null;
  static final Logger log = Logger.getLogger(UserDaoImpl.class);
  static final String USERS_QUERY = "select * from   system.user_details";
  static final String SAVE_USER = "insert into system.user_details values(?,?,?,?,?,?,?,?,?,?)";
  static final String USER_DETAIL = "select * from system.user_details where email=";
  static final String DELETE_USER = "delete  from system.user_details where email=?";
  
  public UserDaoImpl() {}
  
  public List<User> getUsers() throws Exception { List<User> users = new java.util.ArrayList();
    con = DBConnection.getConnection();
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("select * from   system.user_details");
    while (rs.next()) {
      User user = new User();
      user.setEmail(rs.getString(1));
      user.setName(rs.getString(2));
      user.setPass(rs.getString(3));
      user.setDob(rs.getString(4));
      user.setPhno(rs.getString(5));
      user.setAddress(rs.getString(6));
      user.setCity(rs.getString(7));
      user.setState(rs.getString(8));
      user.setStatus(rs.getString(9));
      user.setCenterName(rs.getString(10));
      users.add(user);
    }
    con.close();
    return users;
  }
  
  public boolean saveUser(User user) throws Exception {
    con = DBConnection.getConnection();
    pst = con.prepareStatement("insert into system.user_details values(?,?,?,?,?,?,?,?,?,?)");
    pst.setString(1, user.getEmail());
    pst.setString(2, user.getName());
    pst.setString(4, user.getDob());
    pst.setString(5, user.getPhno());
    pst.setString(6, user.getAddress());
    pst.setString(7, user.getCity());
    pst.setString(8, user.getState());
    pst.setString(3, user.getPass());
    pst.setString(9, "0");
    pst.setString(10, user.getCenterName());
    pst.execute();
    pst.close();
    con.close();
    log.info("user saved: " + user.getEmail());
    return true;
  }
  

  public boolean updateUser(User user)
    throws Exception
  {
    return false;
  }
  
  public boolean deleteUser(String email) throws Exception {
    Connection con = DBConnection.getConnection();
    PreparedStatement pst = con.prepareStatement("delete  from system.user_details where email=?");
    pst.setString(1, email.trim());
    
    pst.execute();
    log.info("user deleted: " + email);
    return true;
  }
  
  public User getUser(String email) throws Exception {
    try {
      Connection con = DBConnection.getConnection();
      PreparedStatement pst = con.prepareStatement("select * from system.user_details where email='" + email + "'");
      ResultSet rs = pst.executeQuery();
      if (rs.next()) {
        User user = new User();
        user.setEmail(email);
        user.setName(rs.getString(2).trim());
        user.setPass(rs.getString(3).trim());
        user.setDob(rs.getString(4).trim());
        user.setPhno(rs.getString(5).trim());
        user.setAddress(rs.getString(6).trim());
        user.setCity(rs.getString(7).trim());
        user.setState(rs.getString(8).trim());
        user.setStatus(rs.getString(9));
        user.setCenterName(rs.getString(10));
        rs.close();
        pst.close();
        con.close();
        log.info("geting user: " + user.getEmail());
        return user;
      }
      return null;
    } catch (Exception e) {
      System.out.println(e.getMessage()); }
    return null;
  }
  
  public int updateStatus(String email, String status) throws SQLException
  {
    int count = 0;
    String UPDATE_STATUS = "UPDATE system.user_details SET status ='" + status + "' WHERE email = '" + email + "'";
    con = DBConnection.getConnection();
    Statement st = con.createStatement();
    count = st.executeUpdate(UPDATE_STATUS);
    st.close();
    con.close();
    log.info("user status updated " + email + " : " + status);
    return count;
  }
}