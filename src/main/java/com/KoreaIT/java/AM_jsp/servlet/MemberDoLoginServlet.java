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
import jakarta.servlet.http.HttpSession;

@WebServlet("/member/doLogin")
public class MemberDoLoginServlet extends HttpServlet {
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


			SecSql sql = SecSql.from("SELECT *");
			sql.append("FROM `member` WHERE loginId = ?;", loginId);
			
			Map memberRow = DBUtil.selectRow(conn, sql);
			String checkPw = (String)memberRow.get("loginPw");
			String name = (String)memberRow.get("name");
			
			if(checkPw == null || !checkPw.equals(loginPw)) {
				response.getWriter()
				.append("<script>alert('잘못된 아이디 또는 비밀번호 입니다.'); location.replace('loginForm');</script>");
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("loginedMember", memberRow);
			session.setAttribute("loginedMemberId", memberRow.get("id"));
			session.setAttribute("loginedMemberLoginId", memberRow.get("loginId"));
			
			response.getWriter()
					.append(String.format("<script>alert('%s님 반갑습니다.'); location.replace('../home/main');</script>", name));

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