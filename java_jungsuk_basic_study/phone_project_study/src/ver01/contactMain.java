package ver01;

public class contactMain {
	public static void main(String[] args) {
		Contact ct = new Contact("손흥민", "010111", "지메일", "주소", "생일", "친구");
		Contact ct2 = new Contact();
		
		ct2.setName("김두한");
		
		ct2.printAll();
		
		ct.printAll();
	}

}
