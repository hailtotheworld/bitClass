package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class update {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String url = "jdbc:oracle:thin:@192.168.1.2:1521/xepdb1";
		
		String title = "변경제목";
		String content = "변경된내용";
		String files = "";
		int id = 30;
		
		String sql = "UPDATE notice "
				+ "SET "
				+ "    title =?,"
				+ "    content=?,"
				+ "    files=?"
				+ " where id=?";

		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "SCOTT", "tiger");
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, title);
		ps.setString(2, content);
		ps.setString(3, files);
		ps.setInt(4, id);
		
		int result = ps.executeUpdate();
		
		System.out.println(result);
		
		ps.close();
		con.close();
	}

}
