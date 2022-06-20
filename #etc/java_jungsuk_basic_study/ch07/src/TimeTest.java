
class Time {
	private int hour; // 0~23사이의 값을 가져야함.
	private int minute;
	private int second;
	
	public int getHour() {
		return hour;
	}
	
	public void setHour(int hour) {
		if(!(hour>=0 && hour<=23)) {
			return;
		}
		this.hour = hour;
	}
	

}


public class TimeTest {

	public static void main(String[] args) {
		Time t = new Time();
//		t.hour = 100;
		t.setHour(-5); // hour의 값을 21로 변경
		System.out.println(t.getHour());
	}

}
