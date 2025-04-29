package com.KoreaIT.java.AM_jsp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.Map;

import com.KoreaIT.java.AM_jsp.util.DBUtil;
import com.KoreaIT.java.AM_jsp.util.SecSql;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class HomeController {

	private Connection conn;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private boolean isLogined() {
		return request.getSession().getAttribute("loginedMember") != null;
	}
	
	private Map<String, Object> getLoginedMember() {
		return isLogined() ? (Map<String, Object>) request.getSession().getAttribute("loginedMember") : null;
	}

	private int getLoginedMemberId() {
		return isLogined() ? (int) request.getSession().getAttribute("loginedMemberId") : -1;
	}

	public HomeController(HttpServletRequest request, HttpServletResponse response, Connection conn) {
		this.conn = conn;
		this.request = request;
		this.response = response;
	}

	public void showMain() throws ServletException, IOException {
		
		boolean isLogined = isLogined();
		Map<String, Object> loginedMember = getLoginedMember();
		int loginedMemberId = getLoginedMemberId();
		
		request.setAttribute("isLogined", isLogined);
		request.setAttribute("loginedMember", loginedMember);
		request.setAttribute("loginedMemberId", loginedMemberId);
		
		request.getRequestDispatcher("/jsp/home/main.jsp").forward(request, response);
	}
	
	
}
