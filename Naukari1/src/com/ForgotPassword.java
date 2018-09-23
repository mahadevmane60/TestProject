package com;

import data.UserDaoImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import util.MailSender;

@WebServlet({"/ForgotPassword"})
public class ForgotPassword extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  String email = null;
  
  public ForgotPassword() {}
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
  {
    try
    {
      email = request.getParameter("email");
      
      if (!email.equals("")) {
        email = email.trim();
        User user = new UserDaoImpl().getUser(email);
        if (user != null) {
          new MailSender().sendmail("Please login with following password " + user.getPass(), "Your Password for Online-Seva: ", email);
          request.setAttribute("msg", "alert(\"We sent you password over mail, please check your mail. \")");
          request.getRequestDispatcher("forgotpassword.jsp").forward(request, response);
        }
        else
        {
          request.setAttribute("msg", "alert(\"Your have not registered yet\")");
          request.getRequestDispatcher("forgotpassword.jsp").forward(request, response);
        }
      }
      else {
        response.sendRedirect("forgotpassword.jsp");
      }
    }
    catch (Exception e) {
      request.setAttribute("msg", "alert(\"Opps!, We are facing some errors!!! Please try later \")");
      request.getRequestDispatcher("forgotpassword.jsp").forward(request, response);
    }
  }
}