package com.newlecture.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.app.entity.Notice;

// NoticeService라는 별도의 캡슐을 만들고 거기다가 CRUD작업을 모아놓도록 하겠다.
public class NoticeService {
	
	public List<Notice> getList() throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@192.168.1.2:1521/xepdb1";

		String sql = "SELECT * FROM notice";

		Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버를 로드해
		Connection con = DriverManager.getConnection(url, "SCOTT", "tiger"); //로드된 드라이버가 연결객체를 만들어
		Statement st = con.createStatement(); //연결객체가 실행도구를 생성해
		ResultSet rs = st.executeQuery(sql); //실행도구가 결과집합을 패치하는도구 객체를 만들어.

		List<Notice> list = new ArrayList<Notice>();

		while(rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerID = rs.getString("WRITER_ID");
			String content = rs.getString("CONTENT");
			String regdate = rs.getString("REGDATE");
			int hit = rs.getInt("HIT");
			String files = rs.getString("FILES");
			
			Notice notice = new Notice(id, title, writerID, content, regdate, hit, files);
			list.add(notice);
			
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
}
