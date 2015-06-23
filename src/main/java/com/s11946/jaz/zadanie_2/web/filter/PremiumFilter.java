/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s11946.jaz.zadanie_2.web.filter;

import com.s11946.jaz.zadanie_2.web.DefaultServlet;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bartek
 */
@WebFilter("/premium.jsp")
public class PremiumFilter extends DefaultFilter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {
		super.init(config);

		System.out.println("PremiumFilter init completed");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(false);

		if(session == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
			return;
		}
		
		
		Object email = session.getAttribute("email");
		if (email != null) {

			if (session.getAttribute("userType").equals(DefaultServlet.ADMIN)
					|| session.getAttribute("userType").equals(
							DefaultServlet.PREMIUM)) {
				chain.doFilter(req, res);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");
				rd.forward(request, response);
			}

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}

	}

	@Override
	public void destroy() {
		

	}

}
