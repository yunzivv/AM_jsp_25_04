package com.home.java.AM_jsp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.home.java.AM_jsp.util.DBUtil;
import com.home.java.AM_jsp.util.SecSql;

@WebServlet("/article/doModify")
public class ArticleModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 x");
			e.printStackTrace();

		}

		String url = "jdbc:mysql://127.0.0.1:3306/AM_JSP_25_04?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "";

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, user, password);
			response.getWriter().append("연결 성공!");

			String title = request.getParameter("title");
			String body = request.getParameter("body");
			int id = Integer.parseInt(request.getParameter("id")); // id가 파라미터로 넘어오지 않는 것 같다.

			SecSql sql = SecSql.from("UPDATE article");
	        sql.append("SET title = ?,", title);
	        sql.append("`body` = ?", body);
	        sql.append("WHERE id = ?;", id);

			response.getWriter()
					.append(String.format("<script>alert('%d번 글이 수정되었습니다.'); location.replace('list');</script>", id));

		} catch (SQLException e) {
			System.out.println("에러 1 : " + e);
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
