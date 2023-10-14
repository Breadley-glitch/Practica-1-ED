package Second;

public class DoubleList {
	private DoubleNode head;
	private DoubleNode tail;
	private int size;
	
	public DoubleList() {
		head=null;
		tail=null;
		size=0;
	}
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DoubleNode current = head; // Asume que 'head' es el primer nodo de tu lista
        while (current != null) {
            sb.append(current.getData().toString()); // Asume que 'data' es el campo de datos en tu nodo
            sb.append("\n"); // Agrega un salto de línea entre cada mensaje
            current = current.getNext(); // Asume que 'next' te da el siguiente nodo en la lista
        }
        return sb.toString();
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size ==0;
	}
	
	public DoubleNode first() {
		return head;
	}
	
	public DoubleNode tail() {
		return tail;
	}
	
	public void addFirst(Object e) {
	    DoubleNode n = new DoubleNode(e);
	    if(isEmpty()) {
	        head = n;
	        tail = n;
	    } else {
	        n.setNext(head);
	        head.setPrev(n);
	        head = n;
	    }
	    size++;
	}

	public void addLast(Object e) {
	    DoubleNode n = new DoubleNode(e);
	    if(isEmpty()) {
	        head = n;
	        tail = n;
	    } else {
	        tail.setNext(n);
	        n.setPrev(tail);
	        tail = n;
	    }
	    size++;
	}
	
	public Object removeFirst() {
		if(isEmpty()) {
			return null;
		}else {
			DoubleNode temp=head;
			head = temp.getNext();
			temp.setNext(null);
			head.setPrev(null);
			size--;
			return temp.getData();
		}
	}
	
	public Object removeLast() {
		if(isEmpty()) {
			return null;
		}else {
			DoubleNode temp= tail;
			tail = temp.getPrev();
			tail.setNext(null);
			tail.setPrev(null);
			size--;
			return temp;
		}
	}
	
	public Object remove(DoubleNode n) {
		if (n==head) {
			return removeFirst();
		}else if (n==tail){
			return removeLast();
		}else {
			Object e = n.getData();
			DoubleNode temp_prev=n.getPrev();
			DoubleNode temp_next=n.getNext();
			temp_prev.setNext(temp_next);
			temp_next.setPrev(temp_prev);
			n.setNext(null);
			n.setPrev(null);
			size--;
			return e;
		}
		
	}
	
	public void addBefore(DoubleNode n, Object e) {
		if (n==head) {
			addFirst(e);
		}else {
			DoubleNode m = new DoubleNode(e);
			DoubleNode temp_prev = n.getPrev();
			temp_prev.setNext(m);
		    m.setPrev(temp_prev);
		    m.setNext(n);
		    n.setPrev(m);
		    size++;
		}
	}
	
	public void addAfter(DoubleNode n, Object e) {
		if (n==tail) {
			addLast(e);
		}else {
			DoubleNode m = new DoubleNode(e);
			DoubleNode temp_next = n.getNext();
			n.setNext(m);
			m.setPrev(n);
			m.setNext(temp_next);
			temp_next.setPrev(m);
			size++;
		}
	}
}
