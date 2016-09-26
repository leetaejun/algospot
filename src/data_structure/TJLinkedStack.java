package data_structure;

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
		return topNode.getData();
	}
	
	public T pop() {
		if (empty()) {
			return null;
		}
		
		T data = topNode.getData();
		topNode = topNode.getNextNode();
		return data;
	}
}
