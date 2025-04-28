package com.KoreaIT.java.AM_jsp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.KoreaIT.java.AM_jsp.util.DBUtil;
import com.KoreaIT.java.AM_jsp.util.SecSql;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/doJoin")
public class MemberDoJoinServlet extends HttpServlet {
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

		String url = "jdbc:mysql://127.0.0.1:3306/AM_jsp_25_04?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "";

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, user, password);
			String loginId = request.getParameter("loginId");
			String loginPw = request.getParameter("loginPw");
			String name = request.getParameter("name");


			SecSql sqlcheck = SecSql.from("SELECT COUNT(*)");
			sqlcheck.append(" FROM `member` WHERE loginId = ?;", loginId);
			boolean isJoinableLoginId = DBUtil.selectRowIntValue(conn, sqlcheck) == 0;
			
			if(!isJoinableLoginId) {
				response.getWriter()
				.append("<script>alert('이미 사용중인 아이디입니다.'); location.replace('joinForm');</script>");
			}
			
			SecSql sql = SecSql.from("INSERT INTO `member`");
	        sql.append("SET regDate = NOW(),");
	        sql.append("loginID = ?,", loginId);
	        sql.append("loginPw = ?,", loginPw);
	        sql.append("`name` = ?;", name);
	        
	        DBUtil.insert(conn, sql);

			response.getWriter()
					.append("<script>alert('회원가입이 완료되었습니다.'); location.replace('../home/main');</script>");

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