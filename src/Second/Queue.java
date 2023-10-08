package Second;

public class Queue {
	private List data;
	
	public Queue() {
		data = new List();
	}
	
	public int size() {
		return data.size();
	}
	
	public boolean isEmpty() {
		return size() ==0;
	}
	
	public void enqueue(Object e) {
		data.addLast(e);
	}
	
	public Object dequeue(Object e) {
		if (isEmpty()) {
			return null;
		}else {
			return data.removeFirst();
		}
	}
}
