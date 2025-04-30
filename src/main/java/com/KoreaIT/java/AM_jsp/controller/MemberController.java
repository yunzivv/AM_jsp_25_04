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

public class MemberController {

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

	public MemberController(HttpServletRequest request, HttpServletResponse response, Connection conn) {
		this.conn = conn;
		this.request = request;
		this.response = response;
	}
	
	public void join() throws ServletException, IOException {
		
		System.out.println(isLogined());
		if(isLogined()) {
			response.getWriter()
			.append("<script>alert('로그아웃 후 가능'); location.replace('../home/main');</script>");
			return;
		}
		
		request.getRequestDispatcher("/jsp/member/join.jsp").forward(request, response);
	}

	public void doJoin() throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");
		String name = request.getParameter("name");


		SecSql sql = SecSql.from("SELECT COUNT(*)");
		sql.append("FROM `member` WHERE loginId = ?;", loginId);
		
		boolean isJoinableLoginId = DBUtil.selectRowIntValue(conn, sql) == 0;
		
		if(!isJoinableLoginId) {
			response.getWriter()
			.append("<script>alert('이미 사용중인 아이디입니다.'); location.replace('join');</script>");
		}
		
		sql = SecSql.from("INSERT INTO `member`");
        sql.append("SET regDate = NOW(),");
        sql.append("loginID = ?,", loginId);
        sql.append("loginPw = ?,", loginPw);
        sql.append("`name` = ?;", name);
        
        DBUtil.insert(conn, sql);

		response.getWriter()
				.append("<script>alert('회원가입이 완료되었습니다.'); location.replace('../home/main');</script>");
		
	}
	
	public void login() throws ServletException, IOException {
		
		if(isLogined()) {
			response.getWriter()
			.append("<script>alert('로그아웃 후 가능'); location.replace('../home/main');</script>");
			return;
		}
		
		request.getRequestDispatcher("/jsp/member/login.jsp").forward(request, response);
		
	}

	public void doLogin() throws ServletException, IOException {

		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");
		
		SecSql sql = SecSql.from("SELECT *");
		sql.append("FROM `member` WHERE loginId = ?;", loginId);
		
		Map memberRow = DBUtil.selectRow(conn, sql);
		String checkPw = (String)memberRow.get("loginPw");
		String name = (String)memberRow.get("name");
		
		if(checkPw == null || !checkPw.equals(loginPw)) {
			response.getWriter()
			.append("<script>alert('잘못된 아이디 또는 비밀번호 입니다.'); location.replace('login');</script>");
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("loginedMember", memberRow);
		session.setAttribute("loginedMemberId", memberRow.get("id"));
		session.setAttribute("loginedMemberLoginId", memberRow.get("loginId"));
		
		response.getWriter()
				.append(String.format("<script>alert('%s님 반갑습니다.'); location.replace('../home/main');</script>", name));

	}

	public void doLogout() throws ServletException, IOException {

		if(!isLogined()) {
			response.getWriter()
			.append("<script>alert('로그인 안됨'); location.replace('join');</script>");
			return;
		}
		
		HttpSession session = request.getSession();
		session.removeAttribute("loginedMember");
		session.removeAttribute("loginedMemberId");
		session.removeAttribute("loginedMemberLoginId");

		response.getWriter().append("<script>alert('로그아웃 되었습니다.'); location.replace('../home/main');</script>");
	}

	public void mypage() throws ServletException, IOException {
		
		if(!isLogined()) {
			response.getWriter()
			.append("<script>alert('로그인 후 가능'); location.replace('../home/main');</script>");
			return;
		}
		
		request.getRequestDispatcher("/jsp/member/mypage.jsp").forward(request, response);
		
	}

}
