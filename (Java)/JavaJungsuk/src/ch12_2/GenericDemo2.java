package ch12_2;

class EmployeeInfo2{
    public int rank;
    EmployeeInfo2(int rank){ this.rank = rank; }
}
class Person2<T, S>{
    public T info;
    public S id;
    Person2(T info, S id){ 
        this.info = info; 
        this.id = id;
    }
}
public class GenericDemo2 {
    public static void main(String[] args) {
        Person2<EmployeeInfo2, Integer> p1 = new Person2<EmployeeInfo2, Integer>(new EmployeeInfo2(1), 1);
    }
}