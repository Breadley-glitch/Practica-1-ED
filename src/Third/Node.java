package Third;

public class Node {
	private Object data;
	private Node left;
	private Node right;
	
	public Node() {
		data = null;
		left = null;
		right = null;
	}
	
	public Node(Object d) {
		data = d;
		right = null;
		left =null;
	}
	
	public void setData(Object d) {
		this.data = d;
	}
		
	public void setRight(Node n) {
		this.right= n;
	}
	
	public void setLeft(Node p) {
		this.left=p;
	}
	
	public Object getData() {
		return data;
	}
	
	public Node getRight() {
		return right;
	}
	public Node getLeft() {
		return left;
	}
	
}
