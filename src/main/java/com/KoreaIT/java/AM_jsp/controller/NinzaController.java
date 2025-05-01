package com.KoreaIT.java.AM_jsp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.KoreaIT.java.AM_jsp.dto.Article;
import com.KoreaIT.java.AM_jsp.dto.Member;
import com.KoreaIT.java.AM_jsp.service.ArticleService;
import com.KoreaIT.java.AM_jsp.util.DBUtil;
import com.KoreaIT.java.AM_jsp.util.SecSql;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class NinzaController {

	private Connection conn;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ArticleService articleService;

	public NinzaController(HttpServletRequest request, HttpServletResponse response, Connection conn) {
		this.conn = conn;
		this.request = request;
		this.response = response;
		this.articleService = new ArticleService(conn);
	}

	public void contact() throws ServletException, IOException {
		
		request.getRequestDispatcher("/jsp/ninza/contact.jsp").forward(request, response);
	}

}
