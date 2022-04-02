package part3.ex4.UI코드분리하기;

// 스캐너 지울때도 ctrl + shift + o

public class ExamList {
	private Exam[] exams;
	private int current;
	 
	

	// 캡슐화의 가장 큰 장점은 데이터구조의 변화, 오류가 캡슐 안에서만 발생한다는 것이다!

	public Exam get(int i) {

		return this.exams[i];
	}

	public void add(Exam exam) {

//		if(exams의 공간이 없다면) {
//		공간을 늘려주기
//	}
		Exam[] exams = this.exams;
		int size = current;

		// 만약에 공간이 모자라면
		if (exams.length == size) {
			// 1. 크기가 더 큰 새로운 배열을 생성하시오.
			Exam[] temp = new Exam[exams.length + 5];

			// 2. 값을 이주시키기
			for (int i = 0; i < size; i++) {
				temp[i] = exams[i];
			}

			// 3. list.exams가 새로만든 temp 배열을 참조하도록 한다.
			exams = temp;

		}

		exams[current] = exam;
		current++;

	}

	// 생성자: 초기화를 위한 특별한 함수
	// 반환값이 없다.
	// 처음 만들 때 딱 한번만 호출이 가능하다.
	public ExamList() {

		// this는 무조건 받기때문에 생략이 가능하다. 지워도 되면 지워서 쓰자.
		exams = new Exam[3];
		current = 0;
		
	}

	public int size() {
		// TODO Auto-generated method stub
		return current;
	}

}
