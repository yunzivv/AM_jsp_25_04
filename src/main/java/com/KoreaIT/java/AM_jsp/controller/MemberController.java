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
		
		request.setAttribute("methodName", "join");
		request.getRequestDispatcher("/jsp/member/join.jsp").forward(request, response);
	}

	public void doJoin() throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");
		String name = request.getParameter("name");

		boolean isJoinableLoginId = memberService.isJoinableLoginId(loginId);
		
		if(!isJoinableLoginId) {
			response.getWriter()
			.append("<script>alert('이미 사용중인 닌자 아이디'); location.replace('join');</script>");
		}
        
        memberService.doJoin(loginId, loginPw, name);

		response.getWriter()
				.append("<script>alert('닌자가 된 것을 축하한다.'); location.replace('../home/main');</script>");
		
	}
	
	public void login() throws ServletException, IOException {
		
		if(isLogined()) {
			response.getWriter()
			.append("<script>alert('로그아웃 후 가능'); location.replace('../home/main');</script>");
			return;
		}
		
		request.setAttribute("methodName", "login");
		request.getRequestDispatcher("/jsp/member/login.jsp").forward(request, response);
		
	}

	public void doLogin() throws ServletException, IOException {

		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");
		
		Member member = memberService.getMemberByLoginId(loginId);
		
		if(member == null) {
			response.getWriter()
			.append("<script>alert('그런 닌자 아이디는 존재하지 않는다.'); location.replace('login');</script>");
			return;
		}
		
		String checkPw = member.getLoginPw();
		String name = member.getName();
		
		if(!checkPw.equals(loginPw)) {
			response.getWriter()
			.append("<script>alert('잘못된 아이디 또는 비밀번호'); location.replace('login');</script>");
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("loginedMember", member);
		session.setAttribute("loginedMemberId", member.getId());
		session.setAttribute("loginedMemberLoginId", member.getLoginId());
		
		response.getWriter()
				.append(String.format("<script>alert('닌자 %s 확인 완료.'); location.replace('../home/main');</script>", name));

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
			.append("<script>alert('닌자 확인 후 가능'); location.replace('../member/login');</script>");
			return;
		}
		
		request.setAttribute("methodName", "mypage");
		request.getRequestDispatcher("/jsp/member/mypage.jsp").forward(request, response);
		
	}

}
