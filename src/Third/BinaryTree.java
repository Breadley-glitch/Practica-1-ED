package Third;
import java.lang.Math.*;

public class BinaryTree {
	private Node root;
	private int size;
	
	public BinaryTree() {
		root =null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public boolean isRoot(Node v) {
		return v==root;
	}
	
	public boolean isInternal(Node v) {
		return hasLeft(v) || hasRight(v);
	}
	
	public boolean hasLeft(Node v ) {
		return v.getLeft()!=null;
	}
	
	public boolean hasRight(Node v) {
		return v.getRight()!=null;
	}
	
	public Node root() {
		return root;
	}
	
	public Node left(Node v) {
		return v.getLeft();
	}
	
	public Node right(Node v) {
		return v.getRight();
	}
	
	public Node parent(Node v) {
		if (isRoot(v)){
			return null;
		}else {
			Queue Q = new Queue();
			Q.enqueue(root);
			Node temp = root;
			while (!Q.isEmpty() & left(Q.first()) !=v  & right(Q.first() !=v)) {
				temp = Q.dequeue();
				if(hasLeft(temp)) {
					Q.enqueue(left(temp));
				}
				if (hasRight(temp)) {
					Q.enqueue(right(temp));
				}
			}
			return temp;
		}
	}
	
	public int depth(Node v) {
		if (isRoot(v)) {
			return 0;
		}else {
			return 1+depth(parent(v));
		}
		
	}
	
	public int height(Node v) {
		if (!isInternal(v)) {
			return 0;
		}else {
			int h=0;
			h= Math.max(height(left(v)),height(right(v)));
			return 1+h;
		}
	}
	
	public void addRoot(Object e) {
		root= new Node(e);
		size=1;
	}
	
	public void insertLeft(Node v, Object e) {
		Node left= new Node(e);
		v.setLeft(v);
		size++;
	}
	
	public void insertRight(Node v, Object e) {
		Node left= new Node(e);
		v.setRight(v);
		size++;
	}
	
	public void remove(Node v) {
	    Node p = parent(v);
	    if (hasLeft(v) || hasRight(v)) { 
	        Node child;
	        if (hasLeft(v)) {
	            child = left(v);
	        } else {
	            child = right(v);
	        }
	        if (left(p) == v) { 
	            p.setLeft(child);
	        } else {
	            p.setRight(child);
	        }
	        v.setLeft(null);
	        v.setRight(null); 
	    } else { 
	        if (left(p) == v) {
	            p.setLeft(null);
	        } else {
	            p.setRight(null);
	        }
	    }
	    size--;
	}

	
	
	
	
}
