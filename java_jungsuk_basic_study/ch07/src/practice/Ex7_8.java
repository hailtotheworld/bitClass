package practice;
//253

class Product {
	int price;
	int bonusPoint;
		
	public Product(int price) {
		this.price = price;
		bonusPoint = (int) (price/10.0);
	}
}

class Tv1 extends Product {
	Tv1() {
		super(100);
	}
	
	public String toString() {
		return "Tv";
	}
}
	
class computer1 extends Product {
	computer1() {
		super(200);
	}
	
	public String toString() {
		return "computer";
	}
}


class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	
	void buy (Product p) {
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		} else {
			money -= p.price;
			bonusPoint += p.bonusPoint;
		}

	}
}











