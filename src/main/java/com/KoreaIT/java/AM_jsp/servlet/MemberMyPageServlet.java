package com.KoreaIT.java.AM_jsp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;


@WebServlet("/member/mypage")
public class MemberMyPageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Keroro").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		
		Map<String, Object> loginedMember = (Map<String, Object>) session.getAttribute("loginedMember");
		int loginedMemberId = (int) session.getAttribute("loginedMemberId");
		String loginedMemberLoginId = (String)session.getAttribute("loginedMemberLoginId");
		
		request.getRequestDispatcher("/jsp/member/mypage.jsp").forward(request, response);
	}

}
