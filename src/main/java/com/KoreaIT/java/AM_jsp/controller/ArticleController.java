package com.KoreaIT.java.AM_jsp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.KoreaIT.java.AM_jsp.util.DBUtil;
import com.KoreaIT.java.AM_jsp.util.SecSql;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ArticleController {

	private Connection conn;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public ArticleController(HttpServletRequest request, HttpServletResponse response, Connection conn) {
		this.conn = conn;
		this.request = request;
		this.response = response;
	}
	
	private boolean isLogined() {
		return request.getSession().getAttribute("loginedMember") != null;
	}
	
	private Map<String, Object> getLoginedMember() {
		return isLogined() ? (Map<String, Object>) request.getSession().getAttribute("loginedMember") : null;
	}

	private int getLoginedMemberId() {
		return isLogined() ? (int) request.getSession().getAttribute("loginedMemberId") : -1;
	}

	public void showList() throws ServletException, IOException {
		
		// pagenation
		int page = 1;
		
		if(request.getParameter("page") != null && request.getParameter("page").length() != 0) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int itemsInAPage = 10;
		int limitFrom = (page - 1) * itemsInAPage;
		
		// query
		SecSql sql = SecSql.from("SELECT COUNT(*)");
		sql.append("FROM article;");

		int totalCnt = DBUtil.selectRowIntValue(conn, sql);
		int totalPage = (int) Math.ceil(totalCnt / (double)itemsInAPage);

		sql = SecSql.from("SELECT *");
		sql.append("FROM article A");
		sql.append("JOIN `member` M");
		sql.append("ON A.loginId = M.id");
		sql.append("ORDER BY A.id DESC");
		sql.append("LIMIT ?, ?;", limitFrom, itemsInAPage);

		// article 저장
		List<Map<String, Object>> articleRows = DBUtil.selectRows(conn, sql);
		
		// loginedMember
		boolean isLogined = isLogined();
		Map<String, Object> loginedMember = getLoginedMember();
		int loginedMemberId = getLoginedMemberId();
		
		request.setAttribute("page", page);
		request.setAttribute("articleRows", articleRows);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("totalPage", totalPage);
		
		request.setAttribute("isLogined", isLogined);
		request.setAttribute("loginedMember", loginedMember);
		request.setAttribute("loginedMemberId", loginedMemberId);

		request.getRequestDispatcher("/jsp/article/list.jsp").forward(request, response);	
		
	}

	public void showDetail() throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		// article
		SecSql sql = SecSql.from("SELECT *");
		sql.append("FROM article A");
		sql.append("JOIN `member` M");
		sql.append("ON A.loginId = M.id");
		sql.append("WHERE A.id = ?;", id);

		Map<String, Object> articleRow = DBUtil.selectRow(conn, sql);
		
		// loginedMember
//		boolean isLogined = isLogined();
//		Map<String, Object> loginedMember = getLoginedMember();
		int loginedMemberId = getLoginedMemberId();
		
		request.setAttribute("articleRow", articleRow);
		request.setAttribute("loginedMemberId", loginedMemberId);

		request.getRequestDispatcher("/jsp/article/detail.jsp").forward(request, response);
	}

	public void write() throws ServletException, IOException {
		
		if(!isLogined()) {
			response.getWriter()
			.append("<script>alert('로그인 후 사용 가능합니다.'); location.replace('../member/loginForm');</script>");
			return;
		}
		
		request.getRequestDispatcher("/jsp/article/insert.jsp").forward(request, response);
		
	}

	public void doWrite() throws ServletException, IOException {
		
		int loginedMemberId =  getLoginedMemberId();
		
		String title = request.getParameter("title");
		String body = request.getParameter("body");

		SecSql sql = SecSql.from("INSERT INTO article");
        sql.append("SET regDate = NOW(),");
        sql.append("updateDate = NOW(),");
        sql.append("loginId = ?,", loginedMemberId);
        sql.append("title = ?,", title);
        sql.append("`body` = ?;", body);

		int id = DBUtil.insert(conn, sql);

		response.getWriter()
				.append(String.format("<script>alert('%d번 글이 작성되었습니다.'); location.replace('list');</script>", id));
		
	}

	public void modify() throws ServletException, IOException {
		
		
	}

	public void doModify() {
		// TODO Auto-generated method stub
		
	}

	public void doDelete() {
		// TODO Auto-generated method stub
		
	}

}
