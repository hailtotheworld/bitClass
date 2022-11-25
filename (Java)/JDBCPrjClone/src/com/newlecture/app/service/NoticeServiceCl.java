package com.newlecture.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.app.entity.NoticeCl;

// NoticeService라는 별도의 캡슐을 만들고 거기다가 CRUD작업을 모아놓도록 하겠다.
public class NoticeServiceCl {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.1.2:1521/xepdb1";
	private String uid = "SCOTT";
	private String pwd = "tiger";

	
	public List<NoticeCl> getList(int page) throws SQLException, ClassNotFoundException {

		String sql = "SELECT * FROM notice_view where num between ? and ?";

		int start = (page-1)*10+1; // 1 11 21 31 41
		int end = page*10; // 10 20 30 40
		
		Class.forName(driver); //드라이버를 로드해
		Connection con = DriverManager.getConnection(url, uid, pwd); //로드된 드라이버가 연결객체를 만들어
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, start);
		st.setInt(2, end);
		
		ResultSet rs = st.executeQuery(); 
		
		List<NoticeCl> list = new ArrayList<NoticeCl>();
		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("WRITER_ID");
			String content = rs.getString("content");
			String regdate = rs.getString("REGDATE");
			int hit = rs.getInt("HIT");
			String files = rs.getString("FILES");
			
			NoticeCl noticecl = new NoticeCl(id, title, writerId, content, regdate, hit, files);
			
			list.add(noticecl);
			
		}
		
		

		rs.close();
		st.close();
		con.close();
		
		
		return list;
		
	}

	public int insert(NoticeCl noticecl) throws ClassNotFoundException, SQLException {
		

		String sql = "INSERT INTO notice ("
				+ "    title,"
				+ "    writer_id,"
				+ "    content,"
				+ "    files"
				+ ") VALUES (?,?,?,?)";

		Class.forName(driver); //드라이버를 로드해
		Connection con = DriverManager.getConnection(url, uid, pwd); //로드된 드라이버가 연결객체를 만들어
		PreparedStatement st = con.prepareStatement(sql); //연결객체가 실행도구를 생성해
		st.setString(1, noticecl.getTitle());
		st.setString(2, noticecl.getWriterId());
		st.setString(3, noticecl.getContent());
		st.setString(4, noticecl.getFiles());

		int result = st.executeUpdate();
		
		st.close();
		con.close();
		//연결실행결과객체가 생성될때 시스템의 자원을 쓴다.
		//연결실행결과객체가 자원사용하는걸 해제하기위해 .close(); 다른 프로그램이 자원쓸수있도록 성능에 대한 부분이다.
		
		return result;
	}
	
	public int update(NoticeCl noticecl) throws ClassNotFoundException, SQLException {
		

		String sql = "UPDATE notice "
				+ "SET "
				+ "    title = ?,"
				+ "    content = ?,"
				+ "    files = ? "
				+ "WHERE "
				+ "    id = ?";

		Class.forName(driver); //드라이버를 로드해
		Connection con = DriverManager.getConnection(url, uid, pwd); //로드된 드라이버가 연결객체를 만들어
		PreparedStatement st = con.prepareStatement(sql); //연결객체가 실행도구를 생성해
		st.setString(1, noticecl.getTitle());
		st.setString(2, noticecl.getContent());
		st.setString(3, noticecl.getFiles());
		st.setInt(3, noticecl.getId());

		int result = st.executeUpdate();
		
		st.close();
		con.close();
		//연결실행결과객체가 생성될때 시스템의 자원을 쓴다.
		//연결실행결과객체가 자원사용하는걸 해제하기위해 .close(); 다른 프로그램이 자원쓸수있도록 성능에 대한 부분이다.
		
		return result;
	}
	
	public int delete(int id) throws ClassNotFoundException, SQLException {

		String sql = "DELETE FROM notice WHERE id = ?";

		Class.forName(driver); //드라이버를 로드해
		Connection con = DriverManager.getConnection(url, uid, pwd); //로드된 드라이버가 연결객체를 만들어
		PreparedStatement st = con.prepareStatement(sql); //연결객체가 실행도구를 생성해
		st.setInt(1, id);

		int result = st.executeUpdate();
		
		st.close();
		con.close();
		//연결실행결과객체가 생성될때 시스템의 자원을 쓴다.
		//연결실행결과객체가 자원사용하는걸 해제하기위해 .close(); 다른 프로그램이 자원쓸수있도록 성능에 대한 부분이다.
		
		return result;
	}
	
}









