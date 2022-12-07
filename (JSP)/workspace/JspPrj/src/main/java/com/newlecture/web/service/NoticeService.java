package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.newlecture.web.entity.Notice;

public class NoticeService {
	
	////
	public List<Notice> getNoticeList() {
		return getNoticeList("title", "", 1);
	}
	
	public List<Notice> getNoticeList(int page) {
		return getNoticeList("title", "", page);
	}
	
	public List<Notice> getNoticeList(String field/*title, writer_id*/, String query /*a*/, int page) {
		
		List<Notice> list = new ArrayList<Notice>();
		
		String sql = "select * from ( "
				+ "select rownum num, N.* "
				+ "from (select * from notice where "+ field +" like ? order by regdate desc) N) "
				+ "where num between ? and ?";
		// 1, 11, 21, 31 -> 1 + (page-1)*10
		// 10, 20, 30, 40 -> 10page
		
		String url = "jdbc:oracle:thin:@192.168.1.2:1521/xepdb1";
		String uid = "SCOTT";
		String pwd = "tiger";
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, uid, pwd);
			st = con.prepareStatement(sql);
			st.setString(1, "%"+query+"%"); // 값이들어갈때는 '값' 이렇게 홑따옴표가 같이 들어가는거다.
			st.setInt(2, 1+(page-1)*10);    // 값이들어갈때는 '값' 이렇게 홑따옴표가 같이 들어가는거다.
			st.setInt(3, 10*page);          // 값이들어갈때는 '값' 이렇게 홑따옴표가 같이 들어가는거다.
			rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				Date regdate = rs.getDate("REGDATE");
				String writerId = rs.getString("WRITER_ID");
				int hit = rs.getInt("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				
				Notice notice = new Notice( id,  title,  regdate,  writerId,  hit,  files,  content);

				list.add(notice);				
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close();} catch (SQLException e) {e.printStackTrace();};
			if(st!=null) try { st.close();} catch (SQLException e) {e.printStackTrace();};
			if(con!=null) try { con.close();} catch (SQLException e) {e.printStackTrace();};
		}
		
		
		return list; 
	}

	////
	public int getNoticeCount() {
		return getNoticeCount("title", "");
	}
	
	
	public int getNoticeCount(String field, String query) {
		
		String sql = "select * from ( "
				+ "select rownum num, N.* "
				+ "from (select * from notice order by regdate desc) N) "
				+ "where num between ? and ?";
		
		return 0;
	}
	
	////
	public Notice getNotice(int id) {
		String sql = "select * from notice where id = ?";
		return null;
	}
	
	public Notice getNextNotice(int id) {
		
		/*
		String sql = "select * " 
				+ "from "
				+ "(select rownum num, N.* "
				+ "from "
				+ "(select * from notice order by regdate desc) N) "
				+ "where num = (select num "
				+ "from "
				+ "(select rownum num, N.* "
				+ "from "
				+ "(select * from notice order by regdate desc) N) "
				+ "where id = ?)-1";
		*/
		
		String sql = "select * "
				+ "from "
				+ "(select * from notice where regdate > (select regdate from notice where id = ?) order by regdate) "
				+ "where rownum = 1";
		return null;
	}
	
	public Notice getPrevNotice(int id) {
		
		String sql = "select * "
				+ "from "
				+ "(select * from notice where regdate < (select regdate from notice where id = ?) order by regdate desc) "
				+ "where rownum = 1";
		return null;
	}
}




