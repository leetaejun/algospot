package com.taejun.data_structure;

public class TJNode<T> {
	private T data;
	private TJNode<T> nextNode;
	
	public TJNode() {
		this.data = null;
		this.nextNode = null;
	}
	
	public TJNode(T data) {
		this.data = data;
		this.nextNode = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public TJNode<T> getNextNode() {
		return this.nextNode;
	}

	public void setNextNode(TJNode<T> nextNode) {
		this.nextNode = nextNode;
	}	
}
