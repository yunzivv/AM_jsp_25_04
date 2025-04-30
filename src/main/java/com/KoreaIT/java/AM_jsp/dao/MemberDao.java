package com.KoreaIT.java.AM_jsp.dao;

import java.sql.Connection;

import com.KoreaIT.java.AM_jsp.util.DBUtil;
import com.KoreaIT.java.AM_jsp.util.SecSql;

public class MemberDao {

	Connection conn;
	
	public MemberDao(Connection conn) {
		this.conn = conn;
	}
	
	public boolean isJoinableId(String loginId) {
		SecSql sql = SecSql.from("SELECT COUNT(*)");
		sql.append("FROM `member` WHERE loginId = ?;", loginId);
		
		return DBUtil.selectRowIntValue(conn, sql) == 0;
	}

}
