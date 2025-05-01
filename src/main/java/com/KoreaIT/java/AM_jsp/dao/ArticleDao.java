package com.KoreaIT.java.AM_jsp.dao;

import java.sql.Connection;
import java.util.*;

import com.KoreaIT.java.AM_jsp.dto.Article;
import com.KoreaIT.java.AM_jsp.util.DBUtil;
import com.KoreaIT.java.AM_jsp.util.SecSql;

public class ArticleDao {

	private Connection conn;

	public ArticleDao(Connection conn) {

		this.conn = conn;
	}
	
	// 총 article 개수 반환
	public int getArticleCnt() {
		
		SecSql sql = SecSql.from("SELECT COUNT(*)");
		sql.append("FROM article;");
		
		return DBUtil.selectRowIntValue(conn, sql);
	}

	// 한 페이지 당 보여줄 article 반환
	public List<Article> getForPrintArticles(String keyword, int limitFrom, int itemsInAPage) {

		SecSql sql = SecSql.from("SELECT *");
		sql.append("FROM article A");
		sql.append("JOIN `member` M");
		sql.append("ON A.loginId = M.id");
		sql.append("WHERE title LIKE ?", "%" + keyword + "%");
		sql.append("ORDER BY A.id DESC");
		sql.append("LIMIT ?, ?;", limitFrom, itemsInAPage);

		List<Map<String, Object>> articleRows = (List<Map<String, Object>>) DBUtil.selectRows(conn, sql);

		List<Article> articles = new ArrayList<>();

		for (Map<String, Object> articleMap : articleRows) {
			articles.add(new Article(articleMap));
		}

		return articles;
	}

	// 해당 id를 가진 article 반환
	public Article getArticle(int id) {
		
		SecSql sql = SecSql.from("SELECT *");
		sql.append("FROM article A");
		sql.append("JOIN `member` M");
		sql.append("ON A.loginId = M.id");
		sql.append("WHERE A.id = ?;", id);
		
		Map<String, Object> articleMap = DBUtil.selectRow(conn, sql);
		
		return new Article(articleMap);
	}

	// article 작성, id 반환
	public int insertAndGetId(int loginedMemberId, String title, String body) {
		
		SecSql sql = SecSql.from("INSERT INTO article");
		sql.append("SET regDate = NOW(),");
		sql.append("updateDate = NOW(),");
		sql.append("loginId = ?,", loginedMemberId);
		sql.append("title = ?,", title);
		sql.append("`body` = ?,", body);
		sql.append("hit = 0;");

		return DBUtil.insert(conn, sql);
	}

	public void updateArticle(String title, String body, int id) {
		
		SecSql sql = SecSql.from("UPDATE article");
		sql.append("SET title = ?,", title);
		sql.append("`body` = ?,", body);
		sql.append("updateDate = NOW()");
		sql.append("WHERE id = ?;", id);

		DBUtil.update(conn, sql);
	}

	public void deleteArticle(int id) {
		
		SecSql sql = SecSql.from("DELETE");
		sql.append("FROM article");
		sql.append("WHERE id = ?;", id);

		DBUtil.delete(conn, sql);
		
	}

	public void updateHits(int id) {
		
		SecSql sql = SecSql.from("UPDATE article");
		sql.append("SET hit = hit + 1");
		sql.append("WHERE id = ?;", id);

		DBUtil.update(conn, sql);
		
	}

}
