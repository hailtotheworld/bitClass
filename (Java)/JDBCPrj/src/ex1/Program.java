package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String url = "jdbc:oracle:thin:@192.168.1.2:1521/xepdb1";
		String sql = "SELECT * FROM notice where hit >= 10";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "SCOTT", "tiger");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		while(rs.next()) {
			
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("WRITER_ID");
			Date regdate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("hit");
			
			
			System.out.printf("id: %d, title: %s, writerId: %s, date: %s, content: %s, hit: %d%n",id,title,writerId,regdate,content,hit);
		}
		
		rs.close();
		st.close();
		con.close();
	}

}
