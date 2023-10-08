package Second;

public class ArrayQueue {
	private Object data[];
	private int first;
	private int rear;
	
	public ArrayQueue(int capacity){
	   data = new Object[capacity];
	   first = -1;
	   rear = -1;
	}
	
	public int size() {
		int temp = data.length - (first + rear);
		int temp1 = temp%data.length+1;
		return temp1;
	}
	
	public boolean isEmpty() {
		return size() ==0;
	}
	
	public void enqueue(Object e) {
		if (size()<data.length) {
			rear = (rear+1)%data.length;
			data[rear]=e;
		}
	}
	
	public Object dequeue(Object e) {
		if (isEmpty()) {
			return null;
		}else {
			Object temp = data[first];
			data[first]=null;
			first = (first+1)%data.length;
			return temp;
		}
	}
	
	
	
}
