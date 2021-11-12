package object;

public class User {
	private int		userId;		// 유저 고유번호
	private String	userName;	// 유저 이름
	private String	password;	// 유저 패스워드
	private String	name;		// 유저 이름   !유저 로그인아이디(userName)과 유저이름(name) 조심!
	private String	email;		// 유저 이메일
	private String	phnum;		// 유저 핸드폰 번호
	private String	address;	// 유저 주소 
	

	public User(int userId, String userName, String password, String name, String email, String phnum, String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phnum = phnum;
		this.address = address;
	}
	
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", phnum=" + phnum + ", address=" + address + "]";
	}



	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhnum() {
		return phnum;
	}
	public void setPhnum(String phnum) {
		this.phnum = phnum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
