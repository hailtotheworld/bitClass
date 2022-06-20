package ver03;

public class Contact_st {
	
	private String name;
	private String phonenumber;
	
	
	public Contact_st(String name, String phonenumber) {
		this.name = name;
		this.phonenumber = phonenumber;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	
	public void printAll() {
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phonenumber);
	}
	
	
	
	

}
