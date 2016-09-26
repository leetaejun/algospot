package data_structure;

public class TJNode {
	private Object data;
	private TJNode nextNode;
	
	public TJNode() {
		this.data = null;
		this.nextNode = null;
	}
	
	public TJNode(Object data) {
		this.data = data;
		this.nextNode = null;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public TJNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(TJNode nextNode) {
		this.nextNode = nextNode;
	}	
}
