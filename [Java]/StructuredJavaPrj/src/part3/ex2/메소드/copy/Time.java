package part3.ex2.메소드.copy;

public class Time {

	int hour; 
	int minute, second;

	public Time(int h,int minute,int second) {
		hour=h;
		this.minute=minute;
		this.second=second;
	}
//
//	public Time() {
//		this(12,34,56);
//	}

	public Time() {
		System.out.println("생성자 호출");
	}

}
