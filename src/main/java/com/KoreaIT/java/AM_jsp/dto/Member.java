package com.KoreaIT.java.AM_jsp.dto;

import java.util.Map;
import java.time.LocalDateTime;

public class Member {

    private int id;
    private LocalDateTime regDate;
    private String loginId;
    private String loginPw;
    private String name;

    public Member(Map<String, Object> articleMap) {
        this.id = (int) articleMap.get("id");
        this.regDate = (LocalDateTime) articleMap.get("regDate");
        this.loginId = (String) articleMap.get("loginId");
        this.loginPw = (String) articleMap.get("loginPw");
        this.name = (String) articleMap.get("name");
    }

    public Member(int id, LocalDateTime regDate, String loginId, String loginPw, String name) {
        this.id = id;
        this.regDate = regDate;
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.name = name;
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

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginPw() {
        return loginPw;
    }

    public void setLoginPw(String loginPw) {
        this.loginPw = loginPw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}