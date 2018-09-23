package com;

import data.UserDaoImpl;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import org.apache.log4j.Logger;
import util.MailSender;

@WebServlet({"/useraccess"})
public class UserAccess extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  static final Logger log = Logger.getLogger(UserAccess.class);
  String email = null; String status = null;
  
  public UserAccess() {}
  
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException { PrintWriter pw = response.getWriter();
    try {
      String statusMsg = "Activated";
      email = request.getParameter("email");
      if (email != null) {
        email = email.trim();
        status = new UserDaoImpl().getUser(email).getStatus().trim();
        log.info("existing: " + status);
        if (status.equals("0")) {
          status = "1";
          statusMsg = "Activated";
        }
        else {
          status = "0";
          statusMsg = "Deactivated";
        }
        if (new UserDaoImpl().updateStatus(email, status) > 0) {
          log.info("after up: " + status);
          pw.println("Updated status sucessfully: " + statusMsg);
          updateOnEmail(email, statusMsg);
        } else {
          pw.println("Email is wrong ");
          log.warn("wrong email: " + email);
        }
      }
      else {
        log.error("email is empty: " + email + " : " + status);
        pw.write("Email is empty");
        pw.flush();
      }
    }
    catch (Exception e) {
      log.error(e.getMessage());
      pw.print("Please try later...");
      pw.flush();
    } finally {
      if (pw != null) {
        pw.close();
      }
    }
  }
  
  private void updateOnEmail(String email, String status) throws Exception
  {
    try
    {
      String mailTo = email.trim();
      String body = "Your account is " + status;
      String subject = "Your account activation status";
      new MailSender().sendmail(body, subject, mailTo);
      return;
    } catch (Exception e) {
      log.error(email + " : " + e.getMessage());
    }
  }
}