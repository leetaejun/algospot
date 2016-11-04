package com.taejun.data_structure;

public class TJLinkedStack<T> {
	private TJNode<T> topNode;
	
	public TJLinkedStack() {
		topNode = null;
	}
	
	public boolean empty() {
		return topNode == null;
	}
	
	public void push(T data) {
		TJNode<T> newNode = new TJNode<>(data);
		newNode.setNextNode(topNode);
		topNode = newNode;
	}
	
	public T peak() {
		if (empty()) {
			return null;
		}
		
		return topNode.getData();
	}
	
	public T pop() {
		T data = peak();
		topNode = topNode.getNextNode();
		return data;
	}
}
