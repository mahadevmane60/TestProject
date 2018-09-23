package com;

import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter({"/mahadev"})
public class LoginFilter
  implements Filter
{
  public LoginFilter() {}
  
  public void destroy() {}
  
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException
  {
    HttpServletRequest req = (HttpServletRequest)request;
    
    if (req.getSession().getAttribute("user") != null)
    {
      chain.doFilter(request, response);
    }
    else if (req.getServletPath().equals("/Login")) {
      chain.doFilter(request, response);
    } else if (req.getServletPath().equals("/SignUp.jsp")) {
      chain.doFilter(request, response);
    } else if (req.getServletPath().equals("/login.jsp")) {
      chain.doFilter(request, response);
    } else {
      request.getRequestDispatcher("index.jsp").include(request, response);
    }
  }
  

  public void init(FilterConfig fConfig)
    throws ServletException
  {
    System.out.println("in init ");
  }
}