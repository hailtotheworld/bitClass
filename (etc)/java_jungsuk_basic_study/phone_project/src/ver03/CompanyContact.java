package ver03;

public class CompanyContact extends Contact{

	// 상속하고 새로운 변수 추가
	private String companyName; // 회사이름
	private String divName;		// 부서이름
	private String job; 		// 직급
	
	
	// 생성자 ////////////////////////////////////////////////////////////////////////////////////////
	public CompanyContact(
			String name,
			String phoneNumber,
			String email,
			String address,
			String birth,
			String group,
			String companyName,
			String divName,
			String job) {
		
		// 상위 클래스의 생성자 호출
		super(name, phoneNumber, email, address, birth, group);
		
		this.companyName = companyName;
		this.divName = divName;
		this.job = job;
	}



	// 상속관계에서 생성자는 상속을 받는게 아니라, 직접 상위클래스에 요청을해서 초기화를 해주는 것이다.
	public CompanyContact(String name, String phoneNumber, String email, String address, String birth, String group) {
		super(name, phoneNumber, email, address, birth, group);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////


	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDivName() {
		return divName;
	}
	public void setDivName(String divName) {
		this.divName = divName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}

	
	@Override
	public void printContact() {
		super.printContact();
		System.out.println("회사이름: " + companyName);
		System.out.println("부서이름: " + divName);
		System.out.println("직급: " + job);
	}
	
	
	
	

	
	
	
	
	

}
