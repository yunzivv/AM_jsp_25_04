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

public class ArticleController {

	private Connection conn;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ArticleService articleService;

	public ArticleController(HttpServletRequest request, HttpServletResponse response, Connection conn) {
		this.conn = conn;
		this.request = request;
		this.response = response;
		this.articleService = new ArticleService(conn);
	}

	private Article getArticle(int id) {

		SecSql sql = SecSql.from("SELECT *");
		sql.append("FROM article");
		sql.append("WHERE id = ?;", id);

		Map<String, Object> articleRow = DBUtil.selectRow(conn, sql);

		return articleRow != null ? new Article(articleRow) : null;
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

	private String getLoginedMemberLoginId() {
		return isLogined() ? (String) request.getSession().getAttribute("loginedMemberLoginId") : null;
	}

	public void showList() throws ServletException, IOException {

		// pagenation
		int page = 1;

		if (request.getParameter("page") != null && request.getParameter("page").length() != 0) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		int itemsInAPage = 10;
		int limitFrom = (page - 1) * itemsInAPage;
		int totalCnt = articleService.getArticleCnt();
		int totalPage = (int) Math.ceil(totalCnt / (double) itemsInAPage);

		List<Article> articles = articleService.getForPrintArticles(limitFrom, itemsInAPage);

		request.setAttribute("page", page);
		request.setAttribute("articles", articles);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("totalPage", totalPage);

		request.setAttribute("isLogined", isLogined());
		request.setAttribute("loginedMember", getLoginedMember());
		request.setAttribute("loginedMemberId", getLoginedMemberId());

		request.getRequestDispatcher("/jsp/article/list.jsp").forward(request, response);

	}

	public void showDetail() throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		request.setAttribute("article", articleService.getArticle(id));
		
		request.setAttribute("isLogined", isLogined());
		request.setAttribute("loginedMember", getLoginedMember());
		request.setAttribute("loginedMemberId", getLoginedMemberId());

		request.getRequestDispatcher("/jsp/article/detail.jsp").forward(request, response);
	}

	public void write() throws ServletException, IOException {

		if (!isLogined()) {
			response.getWriter()
					.append("<script>alert('로그인 후 사용 가능합니다.'); location.replace('../member/login');</script>");
			return;
		}

		request.getRequestDispatcher("/jsp/article/insert.jsp").forward(request, response);

	}

	public void doWrite() throws ServletException, IOException {

		int loginedMemberId = getLoginedMemberId();
		String title = request.getParameter("title");
		String body = request.getParameter("body");

		int id = articleService.insertAndGetId(loginedMemberId, title, body);

		response.getWriter()
				.append(String.format("<script>alert('%d번 글이 작성되었습니다.'); location.replace('list');</script>", id));

	}

	public void modify() throws ServletException, IOException {

		// article id
		int id = Integer.parseInt(request.getParameter("id"));

		// 해당 id를 가진 article 저장
		Article article = getArticle(id);
		int writerId = (int) article.getLoginId();
		int loginedMemberId = getLoginedMemberId();

		if (writerId != loginedMemberId) {
			response.getWriter().append(
					String.format("<script>alert('수정권한이 없습니다.'); location.replace('detail?id=%d');</script>", id));

			return;
		}

		request.setAttribute("article", article);
		request.setAttribute("id", id);

		request.getRequestDispatcher("/jsp/article/update.jsp").forward(request, response);

	}

	public void doModify() throws ServletException, IOException {

		String title = request.getParameter("title");
		String body = request.getParameter("body");
		int id = Integer.parseInt(request.getParameter("id"));

		articleService.updateArticle(title, body, id);

		response.getWriter().append(
				String.format("<script>alert('%d번 글이 수정되었습니다.'); location.replace('detail?id=%d');</script>", id, id));

	}

	public void doDelete() throws ServletException, IOException {

		// article id
		int id = Integer.parseInt(request.getParameter("id"));

		// article 작성자 id
		Article article = getArticle(id);
		int writerId = (int) article.getLoginId();

		// 로그인 멤버 id
		int loginedMemberId = getLoginedMemberId();

		if (writerId != loginedMemberId) {

			response.getWriter().append(
					String.format("<script>alert('삭제 권한이 없습니다.'); location.replace('detail?id=%d');</script>", id));
			return;
		}

		articleService.deleteArticle(id);

		response.getWriter()
				.append(String.format("<script>alert('%d번 글이 삭제됐답니다.'); location.replace('list');</script>", id));

	}

}
