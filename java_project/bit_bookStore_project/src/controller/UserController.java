package controller;

import java.sql.Connection;

import dao.UserDao;

public class UserController {

	UserDao userDao;
	
	public UserController() {
		userDao = UserDao.getInstance();
	}
	
	
	//////////////////////  JOIN ////////////////////////////////////
	
	
	// 보류
	/*
		전체 회원 리스트 만들기 : select
			public List<User> selectAllList(Connection conn){
				Statement stmt = null;
				ResultSet rs = null;
				List<User> list = new ArrayList<User>();
				
				try {
					stmt = conn.createStatement();
					String sql = "select * from bit_users";
					
					rs = stmt.executeQuery(sql);
					while(rs.next()) {
						list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), 
								rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					JdbcUtil.close(rs);
					JdbcUtil.close(stmt);
				}
				
				return list;
			}
	 */
	
	
	
	//////////////////////  LOGIN ////////////////////////////////////
	
	// 로그인
	public void logIn(Connection conn) {
		while (true) {
			/*
			System.out.println("아이디를 입력해주세요.");
			System.out.print("> ");
			String username = getString();
			System.out.println("비밀번호를 입력해주세요.");
			System.out.print("> ");
			String password = getString();

			logIn = userDao.auth(conn, username, password);
			if (logIn == null) {
				System.out.println("로그인에 실패했습니다. 다시 한 번 확인해주세요.");
			} else {
				System.out.println("로그인 성공!");
				System.out.println(logIn.getName() + " 님, 환영합니다.");
				break;
			}
			*/
		}
	}
	
	
	
	// 로그인 성공/실패 여부 
	public int auth(String username, String password) {
		int result = 0;
		result = userDao.authChk(username, password);

		return result;
	}

	
	
	

	//////////////////////  내정보 ////////////////////////////////////

	
	
	///////////////////// 	기타		//////////////////////////////////

	
	/*
		// 공백을 입력하면 예외가 발생하는
		public String getString() {
			String result = null;
	
			while (true) {
	
				result = sc.nextLine().trim();
				if (result.isEmpty()) {
					BadInputException be = new BadInputException("공백은 입력할 수 없습니다. 다시 입력해주세요.");
					try {
						throw be;
					} catch (BadInputException e) {
						System.out.println(e.getMessage());
						System.out.print("> ");
					}
				} else {
					break;
				}
			}
	
			return result;
		}
	
	
		// 이름에 한글과 영문만 가능하도록 하는
		public String getName() {
			String result = null;
			
			while(true) {
				result = getString();
				boolean check = false;
				
				for(int i = 0; i < result.length(); i++) {
					char c = result.charAt(i);
					if() {
						check = true;
						BadInputException be = new BadInputException("");
						break;
					}
				}
				
				if(!check) {
					break;
				}
			}
			return result;
		}
		 
		 
	 * // 아이디에 영문소문자와 숫자만 가능하도록 + 중복 확인
	
		public String getUsername(Connection conn) {
			String username = null;
			username = getString();
			
			// 영문소문자와 숫자로만 되어 있는지 확인
			while(true) {
				username = getString();
				boolean check = false;
				
				for(int i = 0; i < username.length(); i++) {
					char c = username.charAt(i);
					if(!(c >= 'a' && c <= 'z') && !(c >= 0 && c <= 9)) {
						check = true;
						BadInputException be = new BadInputException("영문소문자와 숫자만 입력할 수 있습니다.");
						try {
							throw be;
						} catch (BadInputException e) {
							System.out.println(e.getMessage());
							System.out.println("다시 입력해주세요.");
							System.out.print("> ");
						}
						break;					
					}
				}
				
				if(!check) {
					break;
				}
			} //////////////////////////////////////////////

			while (userDao.usernameCheck(conn, username)) {
				System.out.println("이미 등록된 아이디입니다. 다시 입력해주세요.");
				System.out.print("> ");
				username = getString();
			}

			return username;
		}
	 */

}
