package com.KoreaIT.java.AM_jsp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.Map;

import com.KoreaIT.java.AM_jsp.service.MemberService;
import com.KoreaIT.java.AM_jsp.dto.Member;
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
	private MemberService memberService;
	
	public MemberController(HttpServletRequest request, HttpServletResponse response, Connection conn) {
		this.conn = conn;
		this.request = request;
		this.response = response;
		this.memberService = new MemberService(conn);
	}
	
	private boolean isLogined() {
		return request.getSession().getAttribute("loginedMember") != null;
	}
	
	private Member getLoginedMember() {
		return isLogined() ? (Member) request.getSession().getAttribute("loginedMember") : null;
	}

	private int getLoginedMemberId() {
		return isLogined() ? (int) request.getSession().getAttribute("loginedMemberId") : -1;
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

		boolean isJoinableLoginId = memberService.isJoinableLoginId(loginId);
		
		if(!isJoinableLoginId) {
			response.getWriter()
			.append("<script>alert('이미 사용중인 아이디입니다.'); location.replace('join');</script>");
		}
        
        memberService.doJoin(loginId, loginPw, name);

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
		
		
		Member member = memberService.getMemberByLoginId(loginId);
		
		String checkPw = member.getLoginPw();
		String name = member.getName();
		
		if(member == null || !checkPw.equals(loginPw)) {
			response.getWriter()
			.append("<script>alert('잘못된 아이디 또는 비밀번호 입니다.'); location.replace('login');</script>");
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("loginedMember", member);
		session.setAttribute("loginedMemberId", member.getId());
		session.setAttribute("loginedMemberLoginId", member.getLoginId());
		
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
