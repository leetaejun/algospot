package data_structure;

public class Main {
	public static void main(String args[]) {
		/*
		TJArrayStack arrayStack = new TJArrayStack(5);
		arrayStack.push("0");
		arrayStack.push("1");
		arrayStack.push("2");
		arrayStack.push("3");
		arrayStack.push("4");
		
		int size = arrayStack.size();
		for (int i = 0; i < size; i++) {
			System.out.println(arrayStack.pop());	
		}
		*/
		
		/*
		TJLinkedStack<Integer> linkedStack = new TJLinkedStack<>();
		linkedStack.push(0);
		linkedStack.push(1);
		linkedStack.push(2);
		System.out.println(linkedStack.pop());
		System.out.println(linkedStack.pop());
		System.out.println(linkedStack.pop());
		System.out.println(linkedStack.pop());
		*/
		
		/*
		TJArrayQueue arrayQueue = new TJArrayQueue(5);
		arrayQueue.add("0");
		
		System.out.println(arrayQueue.remove());
		System.out.println(arrayQueue.remove());
		System.out.println(arrayQueue.remove());
		System.out.println(arrayQueue.remove());
		System.out.println(arrayQueue.remove());
		System.out.println(arrayQueue.remove());
		*/
		
		TJLinkedQueue<String> linkedQueue = new TJLinkedQueue<>();
		linkedQueue.add("test1");
		linkedQueue.add("test2");
		linkedQueue.add("test3");
		linkedQueue.add("test4");
		linkedQueue.add("test5");
		linkedQueue.add("test6");
		System.out.println(linkedQueue.remove());
		System.out.println(linkedQueue.remove());
		System.out.println(linkedQueue.remove());
		System.out.println(linkedQueue.remove());
		System.out.println(linkedQueue.remove());
		
	}
}
