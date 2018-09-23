package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.User;
import util.DateUtil;
import data.UserDaoImpl;

@WebServlet("/Register")
public class Register extends HttpServlet {
	final static Logger log = Logger.getLogger(Register.class);
	private static final long serialVersionUID = 1L;
	  String name = null;  
	  String email =null;
	  String pass = null;
	  String dob = null;
	  String phno = null;
	  String address = null;
	  String city = null;
	  String state = null;

    public Register() {
        super();
    }

    User user=null;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try{	
			  request.getSession().invalidate();
			  
			  response.sendRedirect("register.jsp");
			 
		 }catch(Exception e) {
			 log.error(e.getMessage());
			 response.sendRedirect("login.jsp");			 
		 }
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try{	
			 name =   request.getParameter("username");
			
			 email =  request.getParameter("email");
			
			 pass = request.getParameter("userpass");
			
			 dob =  request.getParameter("dob");
		
			 phno = request.getParameter("phno");
			
			 address = request.getParameter("address");
			
			 city = request.getParameter("city");
			
			 state = request.getParameter("state");
		     if(name!=null && email !=null && pass!=null && dob!=null && phno !=null && address !=null &&city !=null && state !=null ) {
		    	  
		    	 name =   request.getParameter("username");
					
				 email =  request.getParameter("email");
				
				 pass = request.getParameter("userpass");
				
				 dob = DateUtil.getHtmlToSqlDate(dob.trim());	
				 phno = phno.trim();
				
				 address = address.trim();
				
				 city = city.trim();
				
				 state = state.trim();
		     }
		     else {
		    	 log.error("not filled all fields "+email);
		    	   request.setAttribute("msg", "alert(\"The all fields are mandatory. Please try again.\")");
				   request.getRequestDispatcher("register.jsp").forward(request, response);	
		    	   return;
		     }
	         user = new User();
	         user.setAddress(address);
	         user.setCity(city);
	         user.setEmail(email);
	         user.setDob(dob);
	         user.setName(name);
	         user.setPass(pass);
	         user.setPhno(phno);
	         user.setState(state);
		    
		     System.out.println(user);  
		     
		       if(new UserDaoImpl().getUser(email)!=null) {
		    	   log.error("acc exists: "+email);
		    	   request.setAttribute("msg", "alert(\"The account this email is akready exists. Please try with different mail id.\")");
				   request.getRequestDispatcher("register.jsp").forward(request, response);		    	   
		       }  
		     
		       else if(new UserDaoImpl().saveUser(user)) {
				   request.getSession().setAttribute("user", user);
				   log.info(" Registered Successfully: "+user.getEmail());
				   request.setAttribute("msg", "alert(\"Registered Sucessfully\")");
				   request.getRequestDispatcher("index.jsp").forward(request, response);
			   }
			   
			 }catch(Exception e){
				 log.error("Error in register: "+e.getMessage());
				 request.setAttribute("msg", "alert(\"Error in registration. Please try later.\")");
				 request.getRequestDispatcher("register.jsp").forward(request, response);
				
			 }
	}

}
