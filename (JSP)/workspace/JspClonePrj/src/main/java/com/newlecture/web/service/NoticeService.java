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

import com.newlecture.web.entitiy.Notice;

public class NoticeService {
	
	public List<Notice> getNoticeList() {
		return getNoticeList("title", "", 1);
	}
	
	public List<Notice> getNoticeList(int page) {
		return getNoticeList("title", "", page);
	}
	
	public List<Notice> getNoticeList(String field, String query, int page) {
		
		List<Notice> list = new ArrayList<Notice>();
		
		String sql = "select * from "
				+ "(select rownum num, N.* "
				+ "from (select * from notice where "+ field + " like ? order by regdate desc) N) "
				+ "where num between ? and ?";
		
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
			st.setString(1, "%"+query+"%");
			st.setInt(2, 1+(page-1)*10); // 1 11 21 31 -> 1+(page-1)*10
			st.setInt(3, page*10); // 10 20 30 40 -> 
			rs = st.executeQuery();
			
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
		
		
		return list;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	
	public int getNoticeCount() {
		return getNoticeCount("title", "");
	}
	
	public int getNoticeCount(String field, String query) {
		
		int count = 0;
		
		String sql = "select count(id) count from "
				+ "(select rownum num, N.* "
				+ "from (select * from notice where "+ field +" like ? order by regdate desc) N);";
		
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
			st.setString(1, "%"+query+"%");
			rs = st.executeQuery();
			
			if(rs.next()) {
				
				count = rs.getInt("count");
			}
		
						
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
		
		
		return count;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////	
	
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
			
			if(rs.next()) {
				
				int nid = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String writerId = rs.getString("WRITER_ID");
				Date regdate = rs.getDate("REGDATE");
				String content = rs.getString("CONTENT");
				int hit = rs.getInt("hit");
				String files = rs.getString("FILES");
			
				notice = new Notice(nid, title, writerId, content, regdate, hit, files);
			}
		
						
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
		
		return notice;
	}
	
	public Notice getPrevNotice(int id) {
		Notice notice = null;
		
		String sql = "select * from "
				+ "(select * from notice "
				+ "where regdate < (select regdate from notice where id = ?) order by regdate desc) "
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
			
			if(rs.next()) {
				
				int nid = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String writerId = rs.getString("WRITER_ID");
				Date regdate = rs.getDate("REGDATE");
				String content = rs.getString("CONTENT");
				int hit = rs.getInt("hit");
				String files = rs.getString("FILES");
			
				notice = new Notice(nid, title, writerId, content, regdate, hit, files);
			}
		
						
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
		
		return notice;
	}
	
	public Notice getNextNotice(int id) {
		Notice notice = null;
		
		String sql = "select * from "
				+ "(select * from notice "
				+ "where regdate > (select regdate from notice where id = ?) order by regdate) "
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
			
			if(rs.next()) {
				
				int nid = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String writerId = rs.getString("WRITER_ID");
				Date regdate = rs.getDate("REGDATE");
				String content = rs.getString("CONTENT");
				int hit = rs.getInt("hit");
				String files = rs.getString("FILES");
			
				notice = new Notice(nid, title, writerId, content, regdate, hit, files);
			}
		
						
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
		
		return notice;
	}

}
