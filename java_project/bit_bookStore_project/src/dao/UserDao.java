package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionProvider;
import object.User;
import util.JdbcUtil;

public class UserDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private UserDao () {										// 싱글톤
		try {
			conn = ConnectionProvider.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static private UserDao userDao = new UserDao();
	
	static public UserDao getInstance() {		return userDao;		};

	//////////////////////////////   JOIN   ///////////////////////////////////

	// 회원가입 (새로운 회원 정보 입력)
	public int insertUser(Connection conn, User user) {
		PreparedStatement pstmt = null;		
		int resultCnt = 0;

		String sql = "insert into bit_users (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			// sql 파라미터 설정
			pstmt.setInt(1, user.getUserId());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getName());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getPhnum());
			pstmt.setString(7, user.getAddress());
			
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}
	// 파라미터로 들어온 아이디와 일치하는 이이디가 이미 존재하면 true를 리턴하는 메소드
		public boolean usernameCheck(Connection conn, String username) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			boolean result = false;
			
			String sql = "select * from bit_users where username = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, username);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result;
		}	

	//////////////////////////////   LOGIN   ///////////////////////////////////
	// 유저 ID,PW 체크
		public int authChk(String username, String password) {
			String sql = "select userid from bit_users where username = ? and password = ?";
			int userId = 0;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				
				rs = pstmt.executeQuery();
				if(rs.next()) {
					userId = rs.getInt(1);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return userId;
		}
	
	
	////////////////////////////// MY INFO   ///////////////////////////////////
	
	// 회원정보 수정 : update
	public int updateUser(Connection conn, User user) {
		PreparedStatement pstmt = null;		
		int resultCnt = 0;

		String sql = "update bit_users set password = ?, email = ?, phnum = ?, address = ? where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			// sql 파라미터 설정
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPhnum());
			pstmt.setString(4, user.getAddress());
			pstmt.setInt(5, user.getUserId());
			
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}
	
	// 회원 정보 삭제 : delete (conn, userid)
	public int deleteUser(Connection conn, int userid) {
		PreparedStatement pstmt = null;
		int resultCnt = 0;
		
		String sql = "delete from bit_users where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userid);
			
			resultCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}


	

	
	
	
	
}
