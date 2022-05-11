
class Time {
	private int hour; // 0~23사이의 값을 가져야 함.
	private int minute;
	private int second;

	// 값을 세팅(입력)하는 메서드
	public void setHour(int hour) {
		if (isNotVaildhour(hour)) // alt + shift + M 메서드 추출
			return;
		this.hour = hour;
	}

	// 매개변수로 넘겨진 hour가 유효한지 확인해서 알려주는 메서드
	private boolean isNotVaildhour(int hour) {
		return hour < 0 || hour > 23;
	}

	// 값을 읽는 메서드
	public int getHour() {
		return hour;
	}

}

public class TimeTest {

	public static void main(String[] args) {
		Time t = new Time();
//		t.hour = 25;
//		System.out.println(t.hour);

		t.setHour(5);
		System.out.println(t.getHour());
		t.setHour(100);
		System.out.println(t.getHour());

	}

}
