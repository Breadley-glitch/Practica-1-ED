package Second;

public class Stack extends List {
	private List data;
	
	public Stack() {
		data = new List();
	}
	
	public int size() {
		return data.size();
	}
	
	public void push(Object e) {
		data.addFirst(e);
	}
	
	public Object pop() {
		return data.removeFirst();
	}
	
	public Object top() {
		if (!isEmpty()) {
			return data.First().getData();
		}else {
			return null;
		}
	}
	
}
