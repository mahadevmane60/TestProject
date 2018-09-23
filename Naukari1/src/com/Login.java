package com;

import data.UserDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import org.apache.log4j.Logger;

@WebServlet({"/Login"})
public class Login extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  static final Logger log = Logger.getLogger(SubmitAdd.class);
  String email = null;
  String pass = null;
  

  public Login() {}
  

  protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    try
    {
      email = request.getParameter("username").trim();
      pass = request.getParameter("userpass").trim();
      
      log.info("Checking Login..." + email + pass);
      if ((email.equals("admin@admin.com")) && (pass.equals("Admin@3131"))) {
        log.info("login with admin" + email);
        request.getRequestDispatcher("AdminView").forward(request, response);
        return;
      }
      User user = new UserDaoImpl().getUser(email);
      
      if (user != null) {
        if (user.getPass().equals(pass)) {
          log.info("Logged in success: " + user.getEmail());
          if (user.getStatus().trim().equals("1")) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("index.jsp#services");
          }
          else {
            log.warn("acc not activated " + user);
            request.setAttribute("msg", "alert( \"Your account is not activated yet. We will update you shortly over mail. \" )");
            request.getRequestDispatcher("login.jsp").forward(request, response);
          }
        } else {
          log.warn("incorrect password " + user);
          request.setAttribute("msg", "alert( \"Incorrect Password \" )");
          request.getRequestDispatcher("login.jsp").forward(request, response);
        }
      }
      else {
        request.setAttribute("msg", "alert( \"You have not registered yet \" )");
        request.getRequestDispatcher("login.jsp").forward(request, response);
        log.error("Not registred yet " + user);
      }
      
    }
    catch (Exception e)
    {
      log.error("Error: Incorrect Email or Password " + e.getMessage());
      request.setAttribute("msg", "alert(\"Error: Incorrect Email or Password\")");
      request.getRequestDispatcher("index.jsp").forward(request, response);
    }
  }
}