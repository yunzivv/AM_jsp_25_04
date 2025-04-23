package com.KoreaIT.java.AM_jsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/PrintDan")
public class PrintDanServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().append("== 8단 ==<br>");
		int dan = 8;
		for(int i = 1; i < 10; i++) {
			response.getWriter().append(String.format("%d * %d = %d<br>", dan, i, dan * i));			
		}
	}

}
