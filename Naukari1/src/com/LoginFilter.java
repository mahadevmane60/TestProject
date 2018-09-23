package com;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/mahadev")
public class LoginFilter implements Filter {

    public LoginFilter() {
        super();

    }

    public void destroy() {
        // System.out.println("destroyed ");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //System.out.println(" before in do filter ");
        HttpServletRequest req = (HttpServletRequest) request;

        if (req.getSession().getAttribute("user") != null) {

            chain.doFilter(request, response);
        } else {
            if (req.getServletPath().equals("/Login")) {
                chain.doFilter(request, response);
            } else if (req.getServletPath().equals("/SignUp.jsp")) {
                chain.doFilter(request, response);
            } else if (req.getServletPath().equals("/login.jsp")) {
                chain.doFilter(request, response);
            } else {
                request.getRequestDispatcher("index.jsp").include(request, response);
            }
            //chain.doFilter(request, response);	
        }
        //  System.out.println(" after in do filter ");
    }

    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("in init ");
    }

}
