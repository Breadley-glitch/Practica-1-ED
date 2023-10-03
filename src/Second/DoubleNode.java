package Second;

public class DoubleNode {
	private Object data;
	private DoubleNode next;
	private DoubleNode prev;
	
	public DoubleNode() {
		data = null;
		prev = null;
		next = null;
	}
	
	public DoubleNode(Object d) {
		data = d;
		prev = null;
		next =null;
	}
	
	public void setData(Object d) {
		this.data = d;
	}
		
	public void setNext(DoubleNode n) {
		this.next= n;
	}
	
	public void setPrev(DoubleNode p) {
		this.prev=p;
	}
	
	public Object getData() {
		return data;
	}
	
	public DoubleNode getNext() {
		return next;
	}
	public DoubleNode getPrev() {
		return prev;
	}
	
}
