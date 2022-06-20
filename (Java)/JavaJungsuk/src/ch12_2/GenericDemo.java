package ch12_2;

class StudentInfo {
	public int grade;

	StudentInfo(int grade) {
		this.grade = grade;
	}
}

class StudentPerson {
	public StudentInfo info;

	StudentPerson(StudentInfo info) {
		this.info = info;
	}
}

class EmployeeInfo {
	public int rank;

	EmployeeInfo(int rank) {
		this.rank = rank;
	}
}

class EmployeePerson {
	public EmployeeInfo2 info;

	EmployeePerson(EmployeeInfo2 info) {
		this.info = info;
	}
}

class Info {
	public int num;
	
	Info(int num) {
		this.num=num;
	}
}

class Person<T extends Info> {
	public T info;
	Person(T info) {
		this.info = info;
	}
	
}

public class GenericDemo {
	public static void main(String[] args) {
		StudentInfo si = new StudentInfo(2);
		StudentPerson sp = new StudentPerson(si);
		System.out.println(sp.info.grade); // 2
		
		EmployeeInfo2 ei = new EmployeeInfo2(1);
		EmployeePerson ep = new EmployeePerson(ei);
		System.out.println(ep.info.rank); // 1
		
		
		
		Info i = new Info(3);
		Person<Info> p = new Person<Info>(i);
		System.out.println(p.info.num);
	}
}



