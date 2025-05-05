package com.KoreaIT.java.AM_jsp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.KoreaIT.java.AM_jsp.controller.ArticleController;
import com.KoreaIT.java.AM_jsp.controller.HomeController;
import com.KoreaIT.java.AM_jsp.controller.MemberController;
import com.KoreaIT.java.AM_jsp.controller.NinzaController;
import com.KoreaIT.java.AM_jsp.dto.Member;
import com.KoreaIT.java.AM_jsp.util.DBUtil;
import com.KoreaIT.java.AM_jsp.util.SecSql;

// s로 시작하는 모든 요청에 대해서 dispatcher가 요청을 받는다.
@WebServlet("/s/*")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// DB 연결
		response.setContentType("text/html;charset=UTF-8");

		try {
			// 드라이버 연결
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패" + e);
			response.getWriter().append("드라이버 로딩실패");
		}

		String url = "jdbc:mysql://127.0.0.1:3306/AM_jsp_25_04?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "";

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, user, password);
			// 연결 성공

			HttpSession session = request.getSession();

			boolean isLogined = false;
			Member loginedMember = null;
			String loginedMemberLoginId = null;

			if (session.getAttribute("loginedMemberLoginId") != null) {
				isLogined = true;
				loginedMemberLoginId = (String) session.getAttribute("loginedMemberLoginId");
				loginedMember = (Member) session.getAttribute("loginedMember");
			}

			request.setAttribute("isLogined", isLogined);
			request.setAttribute("loginedMemberLoginId", loginedMemberLoginId);
			request.setAttribute("loginedMember", loginedMember);

			String requestURI = request.getRequestURI();
			String[] reqURIBits = requestURI.split("/");

			if (reqURIBits.length < 5) {
				response.getWriter().append(
						String.format("<script>alert('올바르지 않은 요청입니다.'); location.replace('home/main');</script>"));
				return;
			}

			String controllerName = reqURIBits[3];
			String actionMethodName = reqURIBits[4];

			if (controllerName.equals("home")) {

				HomeController homeController = new HomeController(request, response, conn);
				
				switch (actionMethodName) {
				case "main":
					homeController.showMain();
					break;
				}

			} else if (controllerName.equals("article")) {

				ArticleController articleController = new ArticleController(request, response, conn);

				switch (actionMethodName) {
				case "list":
					articleController.showList();
					break;
				case "detail":
					articleController.showDetail();
					break;
				case "write":
					articleController.write();
					break;
				case "doWrite":
					articleController.doWrite();
					break;
				case "modify":
					articleController.modify();
					break;
				case "doModify":
					articleController.doModify();
					break;
				case "doDelete":
					articleController.doDelete();
					break;

				}

			} else if (controllerName.equals("member")) {

				MemberController memberController = new MemberController(request, response, conn);

				switch (actionMethodName) {
				case "join":
					memberController.join();
					break;
				case "doJoin":
					memberController.doJoin();
					break;
				case "login":
					memberController.login();
					break;
				case "doLogin":
					memberController.doLogin();
					break;
				case "doLogout":
					memberController.doLogout();
					break;
				case "mypage":
					memberController.mypage();
					break;
				}
			} else if (controllerName.equals("ninza")) {
				
				NinzaController ninzaController = new NinzaController(request, response, conn);
				
				switch(actionMethodName) {
				case "dojo":
					ninzaController.dojo();
					break;
				case "about":
					ninzaController.about();
					break;
				case "contact":
					ninzaController.contact();
					break;
				}
			}

		} catch (SQLException e) {
			System.out.println("에러 : " + e);
			response.getWriter().append("연결실패");

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
