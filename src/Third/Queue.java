package Third;

public class Queue {
    private List data;

    public Queue() {
        data = new List();
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void enqueue(Object e) {
        data.addLast(e);
    }

    public Node dequeue() {
        if (isEmpty()) {
            return null; // Returns null if the queue is empty
        } else {
            return (Node) data.removeFirst();
        }
    }

    
    public Node first() {
        if (isEmpty()) {
            return null;
        } else {
            return (Node) data.First().getData();
        }
    }
   }
