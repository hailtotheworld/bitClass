package controller;

import dao.UserDao;
import object.User;
import util.PatternChk;

public class UserController {

	public UserDao userDao;
	public PatternChk patternChk = new PatternChk();
	
	public UserController() {
		userDao = UserDao.getInstance();

	}
	
	
	//////////////////////  JOIN ////////////////////////////////////
	public void joinUser(String userName, String password, String name, String email, String phnum, String address) {	
		User user = new User(userName, password, name, email, phnum, address);
		int result = userDao.insertUser(user);
		if(result > 0) {
			System.out.println("회원가입이 완료되었습니다.");
		}
	}
	
	
	//////////////////////  LOGIN ////////////////////////////////////
	
	// 로그인에 성공하면 해당 유저의 고유번호를 리턴하는 메소드
	public int auth(String userName, String password) {
		int result = 0;
		result = userDao.authChk(userName, password);

		return result;
	}
	

	//////////////////////  내정보 ////////////////////////////////////

	// 회원정보 보기
	public void showInfo(int userId) {
		User user = userDao.selectByUserId(userId);
		
		System.out.println("================================");
		System.out.println("\t" + user.getName() + " 님의 정보");
		System.out.println("================================");
		
		System.out.println("회원번호: " + userId);
		System.out.println("아이디: " + user.getUserName());
		System.out.println("이름: " + user.getName());
		System.out.println("이메일: " + user.getEmail());
		System.out.println("전화번호: " + user.getPhnum());
		System.out.println("주소: " + user.getAddress());
	}
	
	// 회원정보 수정
	public void updateInfo(String password, String email, String phnum, String address, int userId) {
		int result = userDao.updateUser(password, email, phnum, address, userId);
		if(result > 0) {
			System.out.println("회원정보가 수정되었습니다.");
		}
	}
	
	// 회원 탈퇴
	public int deleteUser(int userId, String password) {
		int result = 0;
		
		if(userDao.passwordChk(userId, password)) {
			result = userDao.deleteUser(userId);
			
			if(result > 0) {
				System.out.println("회원 탈퇴가 완료되었습니다. 이용해주셔서 감사합니다.");
			}
			
		} else {
			System.out.println("비밀번호를 잘못 입력하셨습니다. 회원 탈퇴를 취소합니다.");
		}
		
		return result;
	}
	
}
