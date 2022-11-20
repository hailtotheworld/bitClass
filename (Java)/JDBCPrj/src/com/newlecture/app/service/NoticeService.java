package com.newlecture.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.newlecture.app.entity.Notice;

public class NoticeService {
	public List<Notice> getList() throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@192.168.1.2:1521/xepdb1";
		String sql = "SELECT * FROM notice";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "SCOTT", "tiger");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		List<Notice> list = new ArrayList<Notice>();


		while (rs.next()) {

			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("WRITER_ID");
			Date regdate = rs.getDate("REGDATE"); // import java.util.Date;
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("hit");

			Notice notice = new Notice(id, title, writerId, regdate, content, hit);
			list.add(notice);

		}

		rs.close();
		st.close();
		con.close();

		return list;
	}

	public int insert(Notice notice) {
		return 0;
	}
	
	public int update(Notice notice) {
		return 0;
	}
	
	public int delete(int id) {
		return 0;
	}
}
