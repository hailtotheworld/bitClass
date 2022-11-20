package com.newlecture.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.newlecture.app.entity.Notice;

//NoticeService라는 별도의 캡슐을 만들고 거기다가 CRUD작업을 모아놓도록 하겠다.
public class NoticeService {
	private String url = "jdbc:oracle:thin:@192.168.1.2:1521/xepdb1";
	private String uid = "SCOTT";
	private String pwd = "tiger";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	
	public List<Notice> getList() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM notice";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		List<Notice> list = new ArrayList<Notice>();


		while (rs.next()) {

			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("WRITER_ID");
			Date regdate = rs.getDate("REGDATE"); // import java.util.Date;
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("HIT");
			String files = rs.getString("FILES");

			Notice notice = new Notice(id, title, writerId, regdate, content, hit, files);
			list.add(notice);

		}

		rs.close();
		st.close();
		con.close();

		return list;
	}

	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		
		String title = notice.getTitle();
		String writerId = notice.getWriterId();
		String content = notice.getContent();
		String files = notice.getFiles();
		
		String sql = "INSERT INTO notice ("
				+ "    title,"
				+ "    writer_id,"
				+ "    content,"
				+ "    files"
				+ ") VALUES (?,?,?,?)";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
//		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery(sql);
		
		PreparedStatement st = con.prepareStatement(sql); // sql문을 미리 준비해놓는다.
		        // 미리 값을 다채워놓고 sql문을 준비해서 나중에 update만 할수있게 하라. 실행할때 넘기지말고.
		st.setString(1, title); // index가 1부터시작한다.
		st.setString(2, writerId);
		st.setString(3, content);
		st.setString(4, files);
		
		int result = st.executeUpdate(); //반환값int 몇개row가 반영되었는지알려준다
		
//		rs.close();
		st.close();
		con.close();
		
		return result;
	}
	
	public int update(Notice notice) throws ClassNotFoundException, SQLException {

		String title = notice.getTitle();
		String content = notice.getContent();
		String files = notice.getFiles();
		int id = notice.getId();
		
		String sql = "UPDATE notice "
				+ "SET "
				+ "    title =?,"
				+ "    content=?,"
				+ "    files=?"
				+ " where id=?";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
//		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery(sql);
		
		PreparedStatement st = con.prepareStatement(sql); // sql문을 미리 준비해놓는다.
		        // 미리 값을 다채워놓고 sql문을 준비해서 나중에 update만 할수있게 하라. 실행할때 넘기지말고.
		st.setString(1, title); // index가 1부터시작한다.
		st.setString(2, content);
		st.setString(3, files);
		st.setInt(4, id);
		
		int result = st.executeUpdate(); //반환값int 몇개row가 반영되었는지알려준다
		
		
//		rs.close();
		st.close();
		con.close();
		
		return result;
	}
	
	public int delete(int id) throws ClassNotFoundException, SQLException {

		String sql = "delete notice where id=?";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
//		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery(sql);
		
		PreparedStatement st = con.prepareStatement(sql); // sql문을 미리 준비해놓는다.
		        // 미리 값을 다채워놓고 sql문을 준비해서 나중에 update만 할수있게 하라. 실행할때 넘기지말고.
		st.setInt(1, id); // index 1부터
		
		int result = st.executeUpdate(); //반환값int 몇개row가 반영되었는지알려준다
		
//		rs.close();
		st.close();
		con.close();
		
		return result;
	}
}
