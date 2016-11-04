package com.taejun.data_structure;

public class TJLinkedQueue<T> {
	private TJNode<T> front;
	private TJNode<T> rear;
	
	public TJLinkedQueue() {
		front = null;
		rear = null;
	}
	
	public boolean isEmpty() {
		if (front == null || rear == null) {
			return true;
		}
		
		return false;
	}
	
	public boolean add(T data) {
		boolean result = false;
		if (data == null) {
			result = false;
		}
		
		try {
			TJNode<T> node = new TJNode<>(data);
			
			if (isEmpty()) {
				front = node;
				rear = node;
			} else {
				rear.setNextNode(node);
				rear = node;
			}
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public T peek() {
		if (isEmpty()) {
			throw new NullPointerException(); 
		}
		
		return front.getData();
	}
	
	public T remove() {
		T data = peek();
		front = front.getNextNode();
		
		return data;
	}
}
