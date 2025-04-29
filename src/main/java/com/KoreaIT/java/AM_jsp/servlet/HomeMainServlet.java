package com.KoreaIT.java.AM_jsp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/home/main")
public class HomeMainServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Keroro").append(request.getContextPath());
		
		
		HttpSession session = request.getSession();
		boolean isLogined = false;
		
		if(session.getAttribute("loginedMember") != null) isLogined = true;
		
		request.setAttribute("isLogined", isLogined);
		request.getRequestDispatcher("/jsp/home/main.jsp").forward(request, response);
	}

}
