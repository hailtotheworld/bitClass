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

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

public class NoticeService {
	
	public int deleteNoticeAll(int[] ids){
		
		int result = 0;
		
		String params = "";
		
		for(int i = 0;i<ids.length;i++) {
			params += ids[i];
			if(i < ids.length-1) {
				params += ",";
			}
		}
		
		String sql = "DELETE FROM notice WHERE id in("+params +")";
		String url = "jdbc:oracle:thin:@192.168.1.2:1521/xepdb1";
		String uid = "SCOTT";
		String pwd = "tiger";
		Connection con = null;
		Statement st = null;
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, uid, pwd);
			st = con.createStatement();
			result = st.executeUpdate(sql);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(st!=null) try { st.close();} catch (SQLException e) {e.printStackTrace();};
			if(con!=null) try { con.close();} catch (SQLException e) {e.printStackTrace();};
		}
		
		return result;
	}
	
	public int pubNoticeAll(int[] ids){
		return 0;
	}
	
	public int insertNotice(Notice notice){
		return 0;
	}
	
	public int deleteNotice(int id){
		return 0;
	}
	public int updateNotice(Notice notice){
		return 0;
	}
	
	public List<Notice> getNoticeNewestList(){
		return null;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	////
	public List<NoticeView> getNoticeViewList() {
		return getNoticeViewList("title", "", 1);
	}
	
	public List<NoticeView> getNoticeViewList(int page) {
		return getNoticeViewList("title", "", page);
	}
	
	public List<NoticeView> getNoticeViewList(String field/*title, writer_id*/, String query /*a*/, int page) {
		
		List<NoticeView> list = new ArrayList<NoticeView>();
		
		String sql = "select * from ( "
				+ "select rownum num, N.* "
				+ "from (select * from notice_view where "+ field +" like ? order by regdate desc) N) "
				+ "where num between ? and ?";
		// field를 st.setString(1, field); 로 설정하면 값이 들어가는 걸로 인식해서 'TITLE' 이렇게 홑따옴표가 같이 들어가게 된다.
		
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
			st.setInt(2, 1+(page-1)*10);    // 1, 11, 21, 31 -> 1 + (page-1)*10
			st.setInt(3, 10*page);         	// 10, 20, 30, 40 -> 10page 
			rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				Date regdate = rs.getDate("REGDATE");
				String writerId = rs.getString("WRITER_ID");
				int hit = rs.getInt("HIT");
				String files = rs.getString("FILES");
       			//String content = rs.getString("CONTENT");
				int cmtCount = rs.getInt("CMT_COUNT");
				
				NoticeView notice = new NoticeView(
						id,
						title,
						regdate,
						writerId,
						hit,
						files,
						// content,
						cmtCount);

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
		
		int count = 0;
		
		String sql = "select count(id) count from ( "
				+ "select rownum num, N.* "
				+ "from (select * from notice where "+ field +" like ? order by regdate desc) N) ";
		
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
			rs = st.executeQuery();

			if(rs.next()) { 
				count =  rs.getInt("count");
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
		
		return count;
	}
	
	
	
	
	////
	public Notice getNotice(int id) {
		
		Notice notice = null;
		
		String sql = "select * from notice where id = ?";
		
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
			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				int nid = rs.getInt("ID");
				String title = rs.getString("TITLE");
				Date regdate = rs.getDate("REGDATE");
				String writerId = rs.getString("WRITER_ID");
				int hit = rs.getInt("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				
				notice = new Notice( nid,  title,  regdate,  writerId,  hit,  files,  content);
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
		
		return notice;
	}
	
	
	public Notice getNextNotice(int id) {
		
		Notice notice = null;

		String sql = "select * "
				+ "from (select * from notice where regdate > (select regdate from notice where id=?) order by regdate) "
				+ "where rownum = 1";
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
			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				int nid = rs.getInt("ID");
				String title = rs.getString("TITLE");
				Date regdate = rs.getDate("REGDATE");
				String writerId = rs.getString("WRITER_ID");
				int hit = rs.getInt("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				
				notice = new Notice( nid,  title,  regdate,  writerId,  hit,  files,  content);
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
		
		return notice;
	}
	
	public Notice getPrevNotice(int id) {
		Notice notice = null;
		
		String sql = "select * "
				+ "from (select * from notice where regdate < (select regdate from notice where id=?) order by regdate desc) "
				+ "where rownum = 1";
		
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
			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				int nid = rs.getInt("ID");
				String title = rs.getString("TITLE");
				Date regdate = rs.getDate("REGDATE");
				String writerId = rs.getString("WRITER_ID");
				int hit = rs.getInt("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				
				notice = new Notice( nid,  title,  regdate,  writerId,  hit,  files,  content);
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
		
		return notice;
	}
}




