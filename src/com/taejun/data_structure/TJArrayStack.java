package com.taejun.data_structure;

public class TJArrayStack {
	private Object[] datas;
	private int topIndex;
	private int size;
	
	public TJArrayStack(int capacity) {
		this.datas = new Object[capacity];
		this.topIndex = 0;
		this.size = 0;
	}
	
	public boolean isFull() {
		return this.topIndex == this.datas.length;
	}
	
	public void push(Object data) {
		if (isFull()) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			this.datas[this.topIndex++] = data;
			this.size++;
		}
	}
	
	public Object peak() {
		return this.datas[this.topIndex-1];
	}
	
	public Object pop() {
		Object data = peak();
		this.topIndex--;
		this.size--;
		return data;
	}
	
	public int size() {
		return this.size;
	}
}
