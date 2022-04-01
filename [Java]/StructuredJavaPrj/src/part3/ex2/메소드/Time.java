package part3.ex2.메소드;

public class Time {
	
	int hour,minute,second;
	
	
	public Time(int hour,int minute,int second) {
		this.hour=hour;
		this.minute=minute;
		this.second=second;
	}

	public Time() {
		this(12,34,56);
	}

}
