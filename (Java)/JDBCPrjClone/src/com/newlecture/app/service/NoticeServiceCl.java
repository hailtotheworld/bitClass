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
	private String url = "jdbc:oracle:thin:@192.168.1.2:1521/xepdb1";
	private String uid = "SCOTT";
	private String pwd = "tiger";
	private String driver = "oracle.jdbc.driver.OracleDriver";

	
	public List<NoticeCl> getList() throws SQLException, ClassNotFoundException {

		String sql = "SELECT * FROM notice";

		Class.forName(driver); //드라이버를 로드해
		Connection con = DriverManager.getConnection(url, uid, pwd); //로드된 드라이버가 연결객체를 만들어
		Statement st = con.createStatement(); //연결객체가 실행도구를 생성해
		ResultSet rs = st.executeQuery(sql); //실행도구가 결과집합을 패치하는도구 객체를 만들어.
		//기본적으로 예외를 처리하는 곳은 UI이기 때문에 생기는 예외는 다 던져버려
		
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
			
			System.out.printf("%d,%s,%s,%s,%s,%d,%s\n",id, title, writerId, content, regdate, hit, files);
		}
		
		

		rs.close();
		st.close();
		con.close();
		
		
		return list;
		
	}


	// NoticeCl noticeCl -> 사용자가 전달한 데이터를 사용할거야.
	public int insert(NoticeCl noticeCl) throws ClassNotFoundException, SQLException {
		
		String title = noticeCl.getTitle();
		String writerId = noticeCl.getwriterId();
		String content = noticeCl.getContent();
		String files = noticeCl.getFiles();
		
		String url = "jdbc:oracle:thin:@192.168.1.2:1521/xepdb1";
		String sql = "INSERT INTO notice ("
				+ "    title,"
				+ "    writer_id,"
				+ "    content,"
				+ "    files"
				+ ") VALUES (?,?,?,?)";

		Class.forName(driver); //드라이버를 로드해
		Connection con = DriverManager.getConnection(url, uid, pwd); //로드된 드라이버가 연결객체를 만들어
		PreparedStatement st = con.prepareStatement(sql); //연결객체가 실행도구를 생성해
		st.setString(1, title);
		st.setString(2, writerId);
		st.setString(3, content);
		st.setString(4, files);
		
		int result = st.executeUpdate(); //실행도구가 결과집합을 패치하는도구 객체를 만들어.
			
		st.close();
		con.close();

		return result;
	}
	
	
	public int update(NoticeCl noticeCl) throws ClassNotFoundException, SQLException {
		
		String title = noticeCl.getTitle();
		String content = noticeCl.getContent();
		String files = noticeCl.getFiles();
		int id = noticeCl.getId();
		
		String url = "jdbc:oracle:thin:@192.168.1.2:1521/xepdb1";

		String sql = "UPDATE notice"
				+ " SET "
				+ "    title=?,"
				+ "    content=?,"
				+ "    files=? "
				+ "WHERE "
				+ "    id = ?";

		Class.forName(driver); //드라이버를 로드해
		Connection con = DriverManager.getConnection(url, uid, pwd); //로드된 드라이버가 연결객체를 만들어
		PreparedStatement st = con.prepareStatement(sql); //연결객체가 실행도구를 생성해
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, files);
		st.setInt(4, id);
			
		
		int result = st.executeUpdate(); //실행도구가 결과집합을 패치하는도구 객체를 만들어.
		
		st.close();
		con.close();
		return result;
	}
	
	public int delete(int id) throws ClassNotFoundException, SQLException {

		
		String url = "jdbc:oracle:thin:@192.168.1.2:1521/xepdb1";
		String sql = "DELETE FROM notice WHERE id=?";

		Class.forName(driver); //드라이버를 로드해
		Connection con = DriverManager.getConnection(url, uid, pwd); //로드된 드라이버가 연결객체를 만들어
		PreparedStatement st = con.prepareStatement(sql); //연결객체가 실행도구를 생성해
		st.setInt(1, id);
		
		
		int result = st.executeUpdate(); //실행도구가 결과집합을 패치하는도구 객체를 만들어.

		st.close();
		con.close();
		return result;
	}
	
}









