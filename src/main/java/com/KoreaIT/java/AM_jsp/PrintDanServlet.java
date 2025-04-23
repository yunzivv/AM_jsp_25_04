package com.KoreaIT.java.AM_jsp;


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/PrintDan")
public class PrintDanServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		// request.getRequestDispatcher("jsp/home/printDan.jsp");
		
		String dan = request.getParameter("dan");
		String limit = request.getParameter("limit");
		String color = request.getParameter("color");
		
		if(dan == null) dan = "1";
		if(limit == null) limit = "1";
		if(color == null) color = "black";
		
		int ddan = Integer.parseInt(dan);
		int dlimit = Integer.parseInt(limit);
		
		response.getWriter().print("<div style='color:" + color + "'>");
		
		response.getWriter().append(String.format("== %d단 ==<br>", ddan));
		for(int i = 1; i <= dlimit; i++) {
			response.getWriter().append(String.format("%d * %d = %d<br>", ddan, i, ddan * i));			
		}
		
		response.getWriter().print("</div>");
	}

}
