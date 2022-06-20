package com.newlecture.app.util;

public class GList<T> {

	private Object[] nums;
	private int current; // = 0
	private int capacity; // 용량
	private int amount; // 추가증가량

	public GList() {
		nums = new Object[3];
		current = 0;
		capacity = 3;
		amount = 5;
	}

	public void add(T num) {

//		if(용량이 부족하다면)
//			용량을 늘려

		if (capacity <= current) {
			Object[] temp = new Object[capacity + amount];
			
			for (int i = 0; i < current; i++) {
				temp[i] = nums[i];
				nums = temp;
				capacity += amount;
			}
		}

		nums[current] = num;
		current++;
	}

	public void clear() {
//		for (int i = 0; i < current; i++) 
//			nums[i] = 0;

		// nums = new int[3];
		current = 0;
	}

	public int size() {
		return current;
	}

	public T get(int index) {
		if (current <= index)
			throw new IndexOutOfBoundsException();

		return (T) nums[index];
	}

}
