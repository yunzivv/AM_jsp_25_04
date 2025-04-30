package com.KoreaIT.java.AM_jsp.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.KoreaIT.java.AM_jsp.dao.ArticleDao;
import com.KoreaIT.java.AM_jsp.dto.Article;
import com.KoreaIT.java.AM_jsp.util.DBUtil;
import com.KoreaIT.java.AM_jsp.util.SecSql;

public class ArticleService {

	Connection conn;
	ArticleDao articleDao;

	public ArticleService(Connection conn) {
		this.conn = conn;
		articleDao = new ArticleDao(conn);
	}

	// 현재 article 총 개수 반환
	public int getArticleCnt() {

		return articleDao.getArticleCnt();
	}

	// 한 페이지 당 보여줄 article 반환
	public List<Article> getForPrintArticles(int limitFrom, int itemsInAPage) {

		return articleDao.getForPrintArticles(limitFrom, itemsInAPage);
	}

	// 해당 id를 가진 1개의 article 반환
	public Article getArticle(int id) {

		return articleDao.getArticle(id);
	}

	// article 작성
	public int insertAndGetId(int loginedMemberId, String title, String body) {
		
		return articleDao.insertAndGetId(loginedMemberId, title, body);
	}

	public void updateArticle(String title, String body, int id) {
		
		articleDao.updateArticle(title, body, id);
	}

	public void deleteArticle(int id) {
		
		articleDao.deleteArticle(id);
	}

}
