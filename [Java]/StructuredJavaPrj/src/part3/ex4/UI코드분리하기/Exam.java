package part3.ex4.UI코드분리하기;

public class Exam { // 여기서는 그저 설명서를 만드는 거구나
	int kor;
	int eng;
	int math;

	// 생성자 코드 집중화
	public Exam() {
		this(0,0,0);
	}

	public Exam(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	// getter,setter가 있으면 데이터 구조가 바뀌어도 에러가 해당 클래스에서 발생한다.
	// getter,setter 통해서 캡슐화 유지 가능하다.
	// Shift + Alt + s
	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	

	public int total() {
		return kor + eng + math;
	}

	public float avg() {
		return (float) total() / 3;
	}
 
}