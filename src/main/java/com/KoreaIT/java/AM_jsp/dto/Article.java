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
	private int hit;
	private String writer;
	private int writerGrade;

	public Article(Map<String, Object> articleMap) {
		this.id = (int) articleMap.get("id");
		this.regDate = (LocalDateTime) articleMap.get("regDate");
		this.updateDate = (LocalDateTime) articleMap.get("updateDate");
		this.loginId = (int) articleMap.get("loginId");
		this.title = (String) articleMap.get("title");
		this.body = (String) articleMap.get("body");
		this.hit = (int) articleMap.get("hit");
		this.writer = (String) articleMap.get("name");
		this.writerGrade = (int) articleMap.get("grade");
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public int getLoginId() {
		return loginId;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	public int getHit() {
		return hit;
	}

	public String getWriter() {
		return writer;
	}

	public int getWriterGrade() {
		return writerGrade;
	}
}