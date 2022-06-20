import java.lang.reflect.Method;

class Car2 {
    private final String name;
    private int position;

    public Car2(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }
}

public class ReflectionTest {
	public static void main(String[] args) throws Exception {
	    Object obj = new Car2("foo", 0);
//	    Class carClass = Car2.class;
//	    Class carClass = Class.forName("Car2");
	    Class carClass = obj.getClass();
	    Method move = carClass.getMethod("move");

	    // move 메서드 실행, invoke(메서드를 실행시킬 객체, 해당 메서드에 넘길 인자)
	    move.invoke(obj, null);

	    Method getPosition = carClass.getMethod("getPosition");
	    int position = (int)getPosition.invoke(obj, null);
	    System.out.println(position);
	    // 출력 결과: 1
	}

}
