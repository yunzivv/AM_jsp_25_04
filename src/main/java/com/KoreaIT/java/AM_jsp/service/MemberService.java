package com.KoreaIT.java.AM_jsp.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.KoreaIT.java.AM_jsp.dao.ArticleDao;
import com.KoreaIT.java.AM_jsp.dao.MemberDao;
import com.KoreaIT.java.AM_jsp.dto.Article;
import com.KoreaIT.java.AM_jsp.dto.Member;
import com.KoreaIT.java.AM_jsp.util.DBUtil;
import com.KoreaIT.java.AM_jsp.util.SecSql;

public class MemberService {

	Connection conn;
	MemberDao memberDao;

	public MemberService(Connection conn) {
		this.conn = conn;
		memberDao = new MemberDao(conn);
	}

	public boolean isJoinableLoginId(String loginId) {
		return memberDao.isJoinableId(loginId);
	}

	public Member getMemberByLoginId(String loginId) {
		
		return memberDao.getMemberByLoginId(loginId);
	}
	
	public void doJoin(String loginId, String loginPw, String name) {
		memberDao.doJoin(loginId, loginPw, name);
	}
}
