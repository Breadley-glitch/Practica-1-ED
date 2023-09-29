package Second;

public class Node {
 private Object data;
 private Node next;
 
 public Node() {
	 data = null;
	 next = null;
 }

 
 public Node(Object e) {
	 data=e;
	 next=null;
 }
 
 public Object getData() {
	 return data;
 }
 
 public Node getNext() {
	 return next;
 }
 
 public void setData(Object e) {
	 this.data = e;
 }
 
 public void setNext(Node n) {
	 this.next=n;
 }
}
