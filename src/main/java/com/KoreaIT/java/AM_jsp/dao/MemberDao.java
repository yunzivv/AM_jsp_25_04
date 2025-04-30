package com.KoreaIT.java.AM_jsp.dao;

import java.sql.Connection;
import java.util.Map;

import com.KoreaIT.java.AM_jsp.dto.Member;
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
	
	public Member getMemberByLoginId(String loginId) {
		
		SecSql sql = SecSql.from("SELECT *");
		sql.append("FROM `member` WHERE loginId = ?;", loginId);
		
		Map<String, Object> memberRow = DBUtil.selectRow(conn, sql);
		
		return memberRow.isEmpty() ? null : new Member(DBUtil.selectRow(conn, sql));
		// return member; != null ? member : null
	}

	public void doJoin(String loginId, String loginPw, String name) {
		
		SecSql sql = SecSql.from("INSERT INTO `member`");
        sql.append("SET regDate = NOW(),");
        sql.append("loginID = ?,", loginId);
        sql.append("loginPw = ?,", loginPw);
        sql.append("`name` = ?;", name);
        
        DBUtil.insert(conn, sql);	
	}
	
}
