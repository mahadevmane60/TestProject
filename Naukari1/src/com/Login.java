package com;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import data.UserDaoImpl;
import model.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger log = Logger.getLogger(SubmitAdd.class);
	String email = null;
	String pass = null;

	public Login() {
		super();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			email = request.getParameter("username").trim();
			pass = request.getParameter("userpass").trim();

			log.info("Checking Login..." + email + pass);
			if(email.equals("admin@admin.com") && pass.equals("Admin@3131")) {
				log.info("login with admin"+email);
				List<User> users =new  data.UserDaoImpl().getUsers();
				
				request.setAttribute("users", users);
				request.getRequestDispatcher("adminview.jsp").forward(request, response);
				return;
			}
			User user = new UserDaoImpl().getUser(email);
			
			if (user != null) {
				if (user.getPass().equals(pass)) {
					log.info("Logged in success: "+user.getEmail());
					request.getSession().setAttribute("user", user);
					response.sendRedirect("index.jsp#services");

				} else {
					log.warn("incorrect password " + user);
					request.setAttribute("msg", "alert( \"Incorrect Password \" )");
					request.getRequestDispatcher("login.jsp").forward(request, response);

				}
			} else {
				request.setAttribute("msg","alert( \"You have not registered yet \" )");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				log.error("Not registred yet " + user);

			}
		}

		catch (Exception e) {
			log.error("Error: Incorrect Email or Password " + e.getMessage());
			request.setAttribute("msg", "alert(\"Error: Incorrect Email or Password\")");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

}
