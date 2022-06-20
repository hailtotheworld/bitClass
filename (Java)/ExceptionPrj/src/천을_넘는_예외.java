
// 이 자체가 예외로서 충분하다.
public class 천을_넘는_예외 extends RuntimeException {

	@Override
	public String getMessage() {
		return "입력 값의 합이 1000을 넘는 오류가 발생하였습니다.";
	}
	

}
