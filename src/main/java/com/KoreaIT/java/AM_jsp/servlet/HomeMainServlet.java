package com.KoreaIT.java.AM_jsp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;


@WebServlet("/home/main")
public class HomeMainServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Keroro").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		
		boolean isLogined = false;
		Map<String, Object> loginedMember = null;
		String loginedMemberLoginId = null;

		if (session.getAttribute("loginedMemberLoginId") != null) {
			isLogined = true;
			loginedMemberLoginId = (String) session.getAttribute("loginedMemberLoginId");
			loginedMember = (Map<String, Object>) session.getAttribute("loginedMember");
		}

		request.setAttribute("isLogined", isLogined);
		request.setAttribute("loginedMemberLoginId", loginedMemberLoginId);
		request.setAttribute("loginedMember", loginedMember);
		
		request.getRequestDispatcher("/jsp/home/main.jsp").forward(request, response);
	}

}
