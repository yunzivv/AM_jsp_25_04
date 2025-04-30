package com.KoreaIT.java.AM_jsp.dto;

import java.util.Map;
import java.time.LocalDateTime;

public class Article {

	private int id;
	private LocalDateTime regDate;
	private LocalDateTime updateDate;
	private int loginId;
	private String title;
	private String body;
	private String writer;

	public Article(Map<String, Object> articleMap) {
		this.id = (int) articleMap.get("id");
		this.regDate = (LocalDateTime) articleMap.get("regDate");
		this.updateDate = (LocalDateTime) articleMap.get("updateDate");
		this.loginId = (int) articleMap.get("loginId");
		this.title = (String) articleMap.get("title");
		this.body = (String) articleMap.get("body");
		this.writer = (String) articleMap.get("name");
	}

	public Article(int id, LocalDateTime regDate, LocalDateTime updateDate, int loginId, String title, String body) {
		this.id = id;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.loginId = loginId;
		this.title = title;
		this.body = body;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int memberId) {
		this.loginId = memberId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
}