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
		
		String dan = request.getParameter("dan");
		String limit = request.getParameter("limit");
		
		if(dan == null) dan = "1";
		if(limit == null) limit = "1";
		
		int ddan = Integer.parseInt(dan);
		int dlimit = Integer.parseInt(limit);
		
		response.getWriter().append(String.format("== %d단 ==<br>", ddan));
		for(int i = 1; i <= dlimit; i++) {
			response.getWriter().append(String.format("%d * %d = %d<br>", ddan, i, ddan * i));			
		}
	}

}
