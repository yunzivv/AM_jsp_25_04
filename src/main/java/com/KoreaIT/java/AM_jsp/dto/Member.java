package com.KoreaIT.java.AM_jsp.dto;

import java.util.Map;
import java.time.LocalDateTime;

public class Member {

    private int id;
    private LocalDateTime regDate;
    private String loginId;
    private String loginPw;
    private String name;
    private int grade;

    public Member(Map<String, Object> articleMap) {
        this.id = (int) articleMap.get("id");
        this.regDate = (LocalDateTime) articleMap.get("regDate");
        this.loginId = (String) articleMap.get("loginId");
        this.loginPw = (String) articleMap.get("loginPw");
        this.name = (String) articleMap.get("name");
        this.grade = (int) articleMap.get("grade");
    }


    public int getId() {
        return id;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getLoginPw() {
        return loginPw;
    }

    public String getName() {
        return name;
    }
    
    public int getGrade() {
        return grade;
    }
}