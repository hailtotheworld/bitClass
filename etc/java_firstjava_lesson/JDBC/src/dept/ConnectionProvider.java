package dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	public static Connection getConnection() throws SQLException {
		//static 이유? 자주 사용하니까.
		
		// 2. 연결: Connection
//		String jdbcUrl = "jdbc:oracle:thin:@[주소]:[포트]:[데이터베이스]"
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String pw = "tiger";
		
		return DriverManager.getConnection(jdbcUrl, user, pw);
		
	}

}
