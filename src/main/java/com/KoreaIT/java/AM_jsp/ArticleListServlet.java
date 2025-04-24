package com.KoreaIT.java.AM_jsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@WebServlet("/article/list")
public class ArticleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
	        // 드라이버 연결
	        Class.forName("com.mysql.jdbc.Driver");
	        System.out.println("연결 성공!");

	    } catch (ClassNotFoundException e) {
	        System.out.println("드라이버 로딩 실패" + e);
	    }

		response.getWriter().append("123");
		response.setContentType("text/html;charset=UTF-8");
		
		String url = "jdbc:mysql://127.0.0.1:3306/AM_DB_25_03?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "";
		
		Connection conn = null;
		
		
		try {
            conn = DriverManager.getConnection(url, user, password);
            response.getWriter().append("연결 성공");

        } catch (SQLException e) {
            System.out.println("에러 : " + e);
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}


}
