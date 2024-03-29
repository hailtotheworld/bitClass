package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Program3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String title = "test수정";
		String content = "hahaha3번째";
		String files = "";
		int id = 12;
		
		String url = "jdbc:oracle:thin:@192.168.1.2:1521/xepdb1";
		String sql = "UPDATE notice "
				+ "SET "
				+ "    title =?,"
				+ "    content=?,"
				+ "    files=?"
				+ " where id=?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "SCOTT", "tiger");
//		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery(sql);
		
		PreparedStatement st = con.prepareStatement(sql); // sql문을 미리 준비해놓는다.
		        // 미리 값을 다채워놓고 sql문을 준비해서 나중에 update만 할수있게 하라. 실행할때 넘기지말고.
		st.setString(1, title); // index가 1부터시작한다.
		st.setString(2, content);
		st.setString(3, files);
		st.setInt(4, id);
		
		int result = st.executeUpdate(); //반환값int 몇개row가 반영되었는지알려준다
		
		System.out.println(result);
		
//		rs.close();
		st.close();
		con.close();
	}

}


