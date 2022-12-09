package com.newlecture.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entitiy.Notice;


@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sql = "SELECT * FROM notice";
		String url = "jdbc:oracle:thin:@192.168.1.2:1521/xepdb1";
		String uid = "SCOTT";
		String pwd = "tiger";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		List<Notice> list = new ArrayList<Notice>();
		

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, uid, pwd);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String writerId = rs.getString("WRITER_ID");
				Date regdate = rs.getDate("REGDATE");
				String content = rs.getString("CONTENT");
				int hit = rs.getInt("hit");
				String files = rs.getString("FILES");
			
				Notice notice = new Notice(id, title, writerId, content, regdate, hit, files);
				
				list.add(notice);
			}
		
			request.setAttribute("list", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp");
			dispatcher.forward(request, response);
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(st!=null)
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
			
		
	}



}
