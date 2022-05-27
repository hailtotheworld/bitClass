package ch12;

import java.util.ArrayList;
import java.util.Collections;


class Fruit implements Eatable {
	public String toString() { return "Fruit";}
}
class Apple extends Fruit { public String toString() { return "Apple";}}
class Grape extends Fruit { public String toString() { return "Grape";}}
class Toy                 { public String toString() { return "Toy"  ;}}
class Applee extends Apple {}

interface Eatable {}

class Ex12_3 {
	public static void main(String[] args) {
		
		
		Box<String> bbStr = new Box();    // 지네릭타입참조변수로 원시타입객체가르키는게 가능하다.
		Box bb = new Box<String>(); // 원시타입참조변수로 지네릭타입객체가르키는게 가능하다.
		bb.add(new Integer(100)); // 참조변수가 원시타입니까 가능하다.
		
		Box b = null;
		Box<String> bStr = null;
		
		b = (Box)bStr; 			// Box<String> -> Box 가능하지만 경고. 바람직하지않다.
		bStr = (Box<String>) b; // Box -> Box<String> 가능하지만 경고. 바람직하지않다.
		
		
		
		
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		FruitBox<Grape> grapeBox = new FruitBox<Grape>();
//		FruitBox<Grape> grapeBox = new FruitBox<Apple>(); // 에러. 타입 불일치
//		FruitBox<Toy>   toyBox   = new FruitBox<Toy>();   // 에러.

		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
		
		appleBox.add(new Applee());
		
//		appleBox.add(new Grape());  // 에러. Grape는 Apple의 자손이 아님
		grapeBox.add(new Grape());

		System.out.println("fruitBox-"+fruitBox);
		System.out.println("appleBox-"+appleBox);
		System.out.println("grapeBox-"+grapeBox);
		
		
	}  // main
}

class FruitBox<T extends Fruit & Eatable> extends Box<T> {} // 인터페이스 같이 쓸때는 & 써야한다.

class Box<T> {
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) { list.add(item);     }
	T get(int i)     { return list.get(i); }
	int size()       { return list.size(); }
	public String toString() { return list.toString();}
}