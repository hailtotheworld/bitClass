package ch12;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.*;

import org.junit.jupiter.api.Test;

//@Deprecated
//@SuppressWarnings("1111") // 유효하지 않은 애너테이션은 무시된다.
@TestInfo(testedBy="aaa", testTools = {"JUnit","AutoTester"}, testDate=@DateTime(yymmdd="160101",hhmmss="235959"))
class Ex12_8 {
	public static void main(String args[]) {
		
//		Product clazz = new Product().getClass().newInstance(); // 객체생성하고 getClass()메서드사용하기.
//		Product clazz1 = Product.class.newInstance(); 		    // 클래스이름.class;
//		Product clazz2 = Class.forName("Product").newInstance(); // Class.forName("클래스이름");
		
		// Ex12_8의 Class객체를 얻는다.
		Class<Ex12_8> cls = Ex12_8.class;

		TestInfo anno = cls.getAnnotation(TestInfo.class);
		System.out.println("anno.testedBy()="+anno.testedBy());
		System.out.println("anno.testDate().yymmdd()=" +anno.testDate().yymmdd());
		System.out.println("anno.testDate().hhmmss()=" +anno.testDate().hhmmss());

		for(String str : anno.testTools())
			System.out.println("testTools="+str);

		System.out.println();

		// Ex12_8에 적용된 모든 애너테이션을 가져온다.
		Annotation[] annoArr = cls.getAnnotations();

		for(Annotation a : annoArr)
			System.out.println(a);
	} // main의 끝
}

@Retention(RetentionPolicy.RUNTIME)  // 실행 시에 사용가능하도록 지정 
@interface TestInfo {
	int       count()	  	default 1; // default값이 있는것들은 사용할 때 적지않아도 된다. defalut말고 다른 값주고 싶으면 직접 적어주면 된다.
	String    testedBy();
	String[]  testTools() 	default {"JUnit","JUnit5"};
	TestType  testType()    default TestType.FIRST; // enum타입도 가능하다.
	DateTime  testDate(); // 자신이 아닌 다른 애너테이션을 포함할 수 있다.
}

@Retention(RetentionPolicy.RUNTIME)  // 실행 시에 사용가능하도록 지정
@interface DateTime {
	String yymmdd();
	String hhmmss();
}

enum TestType { FIRST, FINAL }

class Product {
	
}








//@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE}) // TYPE: 클래스,인터페이스, FIELD: iv,cv 멤버변수, TYPE_USE: 참조변수
//@Retention(RetentionPolicy.RUNTIME) // 소스파일ㅇ,클래스파일ㅇ eg)@FunctionalInterface
@Retention(RetentionPolicy.SOURCE) // 소스파일ㅇ,클래스파일X eg)@Override
//@Documented // javadoc로 작성한 문서에 포함시키려면 @Documented를 붙인다.
//@Inherited // 애너테이션을 자손 클래스에 상속하고자 할 때, @Inherited를 붙인다.
@Repeatable(ExTests.class)
@interface ExTest {
	String value();
	
}

@interface ExTests {
	ExTest[] value();
}








