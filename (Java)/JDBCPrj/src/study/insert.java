package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class insert {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String url = "jdbc:oracle:thin:@192.168.1.2:1521/xepdb1";
		
		String sql = "INSERT INTO notice ("
				+ "    title,"
				+ "    writer_id,"
				+ "    content,"
				+ "    files"
				+ ") VALUES (?,?,?,?)";
		
		String title = "제목입니다";
		String writerId = "css";
		String content = "내용테스트입니다";
		String files = "";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "SCOTT", "tiger");
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, title);
		ps.setString(2, writerId);
		ps.setString(3, content);
		ps.setString(4, files);
		
		int result = ps.executeUpdate();
		
		System.out.println(result);
		
		ps.close();
		con.close();
	}

}
