package Third;

public class List {
	private Node head;
	private Node tail;
	private int size;
	
	public List() {
		head=null;
		tail=null;
		size=0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public void setSize(int s) {
		this.size=s;
	}
	
	public Node First() {
		return head;
	}
	
	public Node Last() {
		return tail;
	}
	
	public void addFirst(Object e) {
		Node n = new Node(e);
		if (isEmpty()) {
			head = n;
			tail = n;
		}else {
			n.setRight(head);
			head=n;
		}
		size++;
	}
	
	public void addLast(Object e) {
		Node n = new Node(e);
		if (isEmpty()) {
			head = n;
			tail = n;
		}else {
			tail.setRight(n);
			tail= n;
		}
		size++;
	}
	
	public Object removeFirst() {
		if (!isEmpty()) {
			Node temp = head;
			head = temp.getRight();
			temp.setRight(null);
			size--;
			return temp.getData();
		}else {
			return null;
		}	
	}
	
	public Object removeLast() {
		if (size ==1) {
			return removeFirst();
	    } else {
	        Node temp = tail;
	        Node anterior = head;
	        while (anterior.getRight() != tail) {
	            anterior = anterior.getRight();
	        }
	        anterior.setRight(null);
	        tail = anterior;
	        size--;
	        return temp.getData();
	    }
	}
}
