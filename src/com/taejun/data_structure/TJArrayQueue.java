package com.taejun.data_structure;

public class TJArrayQueue {
	private Object[] datas;
	private int front;
	private int rear;
	private int size;
	
	public TJArrayQueue(int capacity) {
		this.datas = new Object[capacity];
		this.front = 0;
		this.rear = 0;
		this.size = 0;
	}
	
	public boolean isFull() {
		return this.datas.length == this.rear;
	}
	
	public boolean isEmpty() {
		return this.front == this.rear;
	}
	
	public boolean add(Object data) {
		boolean result = false;
		
		if (!isFull() && data != null) {
			this.datas[rear++] = data;
			this.size++;
			result = true;
		}
		
		return result;
	}
	
	public Object peek() throws ArrayIndexOutOfBoundsException {
		if (!isEmpty()) {
			return this.datas[front];
		}
		
		return null;
	}
	
	public Object remove() {
		Object data = peek();
		this.front++;
		this.size--;
		return data;
	}
	
	public int size() {
		return this.size;
	}
}
