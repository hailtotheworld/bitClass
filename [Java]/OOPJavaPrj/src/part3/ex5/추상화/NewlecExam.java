package part3.ex5.추상화;

public class NewlecExam extends Exam {

	private int com;

	// 생성자
	public NewlecExam() {
		this(0, 0, 0, 0); // 오버로드는 반드시 집중화하라
	}

	public NewlecExam(int kor, int eng, int math, int com) {
		super(kor, eng, math);
		this.com = com;
	}

	// getter setter
	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}

	@Override
//	public int total() {
//		int total = onTotal() + com;
//		return total;
//	}
	public int total() {
		return onTotal() + com;
	}

	@Override
	public float avg() {
		return total() / 4.0f;
	}

}
