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

	private HttpServletRequest request;
	private HttpServletResponse response;
	private Connection conn;

	public ArticleController(HttpServletRequest request, HttpServletResponse response, Connection conn) {
		this.conn = conn;
		this.request = request;
		this.response = response;
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
		HttpSession session = request.getSession();
		
		boolean isLogined = false;
		Map<String, Object> loginedMember = null;
		int loginedMemberId = -1;

		if (session.getAttribute("loginedMemberLoginId") != null) {
			isLogined = true;
			loginedMember = (Map<String, Object>) session.getAttribute("loginedMember");
			loginedMemberId = (int) session.getAttribute("loginedMemberId");
		}
		
		request.setAttribute("page", page);
		request.setAttribute("articleRows", articleRows);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("totalPage", totalPage);
		
		request.setAttribute("isLogined", isLogined);
//		request.setAttribute("loginedMember", loginedMember);
//		request.setAttribute("loginedMemberId", loginedMemberId);

		request.getRequestDispatcher("/jsp/article/list.jsp").forward(request, response);	
		
	}

}
