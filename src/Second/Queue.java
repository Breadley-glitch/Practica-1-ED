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
        return size() == 0;
    }

    public void enqueue(Object e) {
        data.addLast(e);
    }

    public Object dequeue() {
        if (isEmpty()) {
            return null; // Devuelve null si la cola está vacía
        } else {
            return data.removeFirst();
        }
    }
}
