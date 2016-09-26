package data_structure;

public class Main {
	public static void main(String args[]) {
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
	}
}
