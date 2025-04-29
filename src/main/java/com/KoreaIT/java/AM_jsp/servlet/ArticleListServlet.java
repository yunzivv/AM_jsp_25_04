package com.KoreaIT.java.AM_jsp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.KoreaIT.java.AM_jsp.util.DBUtil;
import com.KoreaIT.java.AM_jsp.util.SecSql;
import java.util.List;
import java.util.Map;

import com.KoreaIT.java.AM_jsp.util.DBUtil;


@WebServlet("/article/list")
public class ArticleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// DB 연결
		response.setContentType("text/html;charset=UTF-8");
		
		try {
	        // 드라이버 연결
	        Class.forName("com.mysql.jdbc.Driver");
	        System.out.println("연결 성공!");
	        response.getWriter().append("드라이버 로딩 성공! ");

	    } catch (ClassNotFoundException e) {
	        System.out.println("드라이버 로딩 실패" + e);
	        response.getWriter().append("드라이버 로딩실패");
	    }

		String url = "jdbc:mysql://127.0.0.1:3306/AM_jsp_25_04?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "";
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			response.getWriter().append("연결 성공!");
			
			// pagenation
			int page = 1;
			
			if(request.getParameter("page") != null && request.getParameter("page").length() != 0) {
				page = Integer.parseInt(request.getParameter("page"));
			}
			
			int itemsInAPage = 10;
			int limitFrom = (page - 1) * itemsInAPage;
			
			// query
			SecSql sql = SecSql.from("SELECT COUNT(*)");
			sql.append("FROM article;");

			int totalCnt = DBUtil.selectRowIntValue(conn, sql);
			int totalPage = (int) Math.ceil(totalCnt / (double)itemsInAPage);

			sql = SecSql.from("SELECT *");
			sql.append("FROM article A");
			sql.append("JOIN `member` M");
			sql.append("ON A.loginId = M.id");
			sql.append("ORDER BY A.id DESC");
			sql.append("LIMIT ?, ?;", limitFrom, itemsInAPage);

			// article 저장
			List<Map<String, Object>> articleRows = DBUtil.selectRows(conn, sql);
			
			// loginedMember
			HttpSession session = request.getSession();
			
			boolean isLogined = false;
			Map<String, Object> loginedMember = null;
			int loginedMemberId = -1;

			if (session.getAttribute("loginedMemberLoginId") != null) {
				isLogined = true;
				loginedMember = (Map<String, Object>) session.getAttribute("loginedMember");
				loginedMemberId = (int) session.getAttribute("loginedMemberId");
			}
			
			request.setAttribute("page", page);
			request.setAttribute("articleRows", articleRows);
			request.setAttribute("totalCnt", totalCnt);
			request.setAttribute("totalPage", totalPage);
			
			request.setAttribute("isLogined", isLogined);
//			request.setAttribute("loginedMember", loginedMember);
//			request.setAttribute("loginedMemberId", loginedMemberId);

			request.getRequestDispatcher("/jsp/article/list.jsp").forward(request, response);
	
        } catch (SQLException e) {
            System.out.println("에러 : " + e);
            response.getWriter().append("연결실패");
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                
                
            }
        }
	}


}