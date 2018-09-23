package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.SubmitAdd;

import model.User;
import util.*;

public class UserDaoImpl implements UserDao {
	Connection con = null;
	PreparedStatement pst = null;
	final static Logger log = Logger.getLogger(UserDaoImpl.class);
	final static String USERS_QUERY = "select * from   system.user_details";
	final static String SAVE_USER = "insert into system.user_details values(?,?,?,?,?,?,?,?,?)";
	final static String USER_DETAIL = "select * from system.user_details where email=";
    final static String DELETE_USER ="delete  from system.user_details where email=?";
	final static String UPDATE_STATUS = "UPDATE USER_DETAILS SET STATUS =? WHERE email = ?";
	public  List<User> getUsers() throws Exception {
     List<User> users = new ArrayList<User>();
      con = DBConnection.getConnection();
     Statement st = con.createStatement();
     ResultSet rs = st.executeQuery(USERS_QUERY);
     while(rs.next()){
    	 User user= new User();
    	 user.setEmail(rs.getString(1));		 
		 user.setName(rs.getString(2));
		 user.setPass(rs.getString(3));
		 user.setDob(rs.getString(4));
		 user.setPhno(rs.getString(5));
		 user.setAddress(rs.getString(6));
		 user.setCity(rs.getString(7));
		 user.setState(rs.getString(8));	 
    	 
    	 users.add(user);
     }
     con.close();
     return users;
	}

	
	public boolean saveUser(User user) throws Exception {
		 con = DBConnection.getConnection();
		 pst = con.prepareStatement(SAVE_USER);
		pst.setString(1, user.getEmail());
		pst.setString(2, user.getName());
		pst.setString(4,user.getDob());
		pst.setString(5,user.getPhno());
		pst.setString(6,user.getAddress());
		pst.setString(7,user.getCity());
		pst.setString(8,user.getState());
		pst.setString(3,user.getPass());	
		pst.setString(9,"0");		
        pst.execute();
        pst.close();
		con.close();
		log.info("user saved: "+user.getEmail() );
		return true;
	}

	public boolean updateUser(User user)throws Exception {
		
		return false;
	}

	public boolean deleteUser (String email)throws Exception {
	    Connection con = DBConnection.getConnection();
	    PreparedStatement pst = con.prepareStatement(DELETE_USER);		 
	    pst.setString(1,email.trim());
	    pst.execute();
	    log.info("user deleted: "+email);
		return true;
	}

	public  User getUser(String email) throws Exception {
		try{
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(USER_DETAIL+"'"+email+"'");		
		ResultSet rs= pst.executeQuery();
		if( rs.next()){	
		 User user= new User();	  
		 user.setEmail(email);		 
		 user.setName(rs.getString(2).trim());
		 user.setPass(rs.getString(3).trim());
		 user.setDob(rs.getString(4).trim());
		 user.setPhno(rs.getString(5).trim());
		 user.setAddress(rs.getString(6).trim());
		 user.setCity(rs.getString(7).trim());
		 user.setState(rs.getString(8).trim());
		 user.setStatus(rs.getString(9));
		
		 rs.close();
		 pst.close();
		 con.close();
		 log.info("geting user: "+user.getEmail());
		 return user;
		}
		return null;
		}catch(Exception e){ System.out.println(e.getMessage()); return null; }
	}
	
	public boolean updateStatus( String email, String status) throws SQLException {
		con = DBConnection.getConnection();
		pst = con.prepareStatement(UPDATE_STATUS);
		pst.setString(1, status.trim());
		pst.setString(2,email.trim());
		pst.execute();
        pst.close();
		con.close();
		log.info("user status saved: "+email+" : "+status );
		return true;
	}
	
  
}
