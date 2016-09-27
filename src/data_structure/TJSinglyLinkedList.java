package data_structure;

public class TJSinglyLinkedList<T> {
	
	// 멤버변수 선언
	private TJNode<T> head;
	private int size;

	// 생성자
	public TJSinglyLinkedList() {
		this.head = null;
		this.size = 0;
	}

	// 리스트가 비었는지 확인
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}

		return false;
	}

	// 리스트의 마지막에 데이터 추가
	public boolean add(T data) {
		boolean result = false;
		
		try {
			TJNode<T> newNode = new TJNode<>(data);
			if (isEmpty()) {
				head = newNode;
			} else {
				TJNode<T> lastNode = head;
				while (lastNode.getNextNode() != null) {
					lastNode = lastNode.getNextNode();
				}
				lastNode.setNextNode(newNode);
			}
			
			result = true;
			size++;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	// 해당 인덱스에 데이터 추가
	public boolean add(T data, int index) {
		boolean isAddition = false;
		
		if (!isPositionIndex(index)) {
			return isAddition;
		}
		
		try {
			TJNode<T> newNode = new TJNode<>(data);
			if (index == size) {
				if (isEmpty()) {
					head = newNode;
				} else {
					TJNode<T> lastNode = head;
					while (lastNode.getNextNode() != null) {
						lastNode = lastNode.getNextNode();
					}
					lastNode.setNextNode(newNode);
				}
				size++;
			} else {
				TJNode<T> lastNode = head;
				for (int i = 0; i <= index; i++) {
					newNode.setNextNode(lastNode.getNextNode());
					lastNode = lastNode.getNextNode();
				}
				
				lastNode = head;
				for (int i = 0; i < index - 1; i++) {
					lastNode = lastNode.getNextNode();
				}
				lastNode.setNextNode(newNode);
			}
			
			isAddition = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isAddition;
	}
	
	// 리스트의 처음 데이터를 반환
	public T peekFirst() {
		if (isEmpty()) {
			return null;
		}
		
		return head.getData();
	}
	
	// 리스트의 마지막 데이터를 반환
	public T peekLast() {
		if (isEmpty()) {
			return null;
		}
		
		TJNode<T> lastNode = head;
		while (lastNode.getNextNode() != null) {
			lastNode = lastNode.getNextNode();
		}
		
		return lastNode.getData();
	}
	
	// 리스트 데이터 중 인덱스에 해당하는 데이터를 반환
	public T get(int index) {
		if (!isPositionIndex(index)) {
			return null;
		} else {
			TJNode<T> lastNode = head;
			for (int i = 0; i < index; i++) {
				lastNode = lastNode.getNextNode();
			}
			
			return lastNode.getData();
		}
	}
	
	// 리스트의 첫 요소를 제거
	public void removeFirst() {
		if (size() <= 1) {
			head = null;
		} else {	
			head = head.getNextNode();
		}
		
		size--;
	}
	
	// 리스트의 마지막 요소를 제거
	public void removeLast() {
		if (size() <= 1) {
			head = null;
		} else {
			TJNode<T> lastNode = head;
			while (lastNode.getNextNode() != null) {
				if (lastNode.getNextNode().getNextNode() == null) {
					lastNode.setNextNode(null);
					break;
				}
				lastNode = lastNode.getNextNode();
			}
		}
		
		size--;
	}
	
	// 접근 가능한 인덱스인지 체크
	private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

	// 리스트의 사이즈를 반환
	public int size() {
		return size;
	}
}
