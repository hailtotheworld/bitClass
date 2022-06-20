package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class jdbcPreparedStatementSelectTest {
	
	public static void main(String[] args)  {
		
		Connection conn = null;
//		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// Dept 저장을 위한 List<Dept>
		List<Dept> list = new ArrayList<Dept>();
		
		try {
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Referenced Libraries->oracle.jdbs.driver->OracleDriver 이거참고해서작성
			// 작성해주고 try catch 잡아

			// 2. 연결: Connection
//			String jdbcUrl = "jdbc:oracle:thin:@[주소]:[포트]:[데이터베이스]"
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			// import해주고, try catch잡아
			
			System.out.println("데이터베이스 연결 성공!");
			
			// 3. 작업: CRUD -> PreparedStatement 객체 생성
			//	  SQL을 등록해서 생성하기 때문에 Sql 먼저 작성
			
			// Sql: select
			String sql = "select * from dept where deptno=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 60);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
				
			}
			
			
			// 4. 종료: close()
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("데이터베이스에 연결할 수 없습니다. 연결 실패!");
			e.printStackTrace();
		} finally {
			// 예외와 상관없이 실행되어야 하는 블럭임.
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
			if(conn != null) {
				try {
					conn.close(); // try catch잡아
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
			
		}
		

		System.out.println("부서 리스트");
		System.out.println("--------------------");
		System.out.println("부서번호\t부서이릅\t위치");
		System.out.println("--------------------");		
		for(Dept dept : list) {
			System.out.println(dept);
			
		}
		
		
	}

}
