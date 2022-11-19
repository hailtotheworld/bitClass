package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class delete {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String url = "jdbc:oracle:thin:@192.168.1.2:1521/xepdb1";
		
		
		String sql = "delete from notice where id=?";
		
		int id = 31;

		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "SCOTT", "tiger");
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);

		
		int result = ps.executeUpdate();
		
		System.out.println(result);
		
		ps.close();
		con.close();
	}


}
