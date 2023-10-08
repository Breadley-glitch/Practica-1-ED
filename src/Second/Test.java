package Second;

public class Test {
    public static void main(String[] args) {
        // Create a new list
        List myList = new List();

        // Add elements to the list
        myList.addFirst("First Element");
        myList.addLast("Second Element");
        myList.addLast("Third Element");
        myList.addFirst("nine Element");
        
        System.out.println("All elements in the list:");
        Node currentNode = myList.First();
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }

        // Display the list size
        System.out.println("List size: " + myList.size());

        // Display the first and last elements
        System.out.println("First element: " + myList.First().getData());
        System.out.println("Last element: " + myList.Last().getData());

        // Remove and display the first element
        Object removedElement = myList.removeFirst();
        System.out.println("Removed element: " + removedElement);

        // Display the updated list size and first element
        System.out.println("Updated list size: " + myList.size());
        System.out.println("First element after removal: " + myList.First().getData());

        // Remove and display the last element
        removedElement = myList.removeLast();
        System.out.println("Removed element: " + removedElement);

        // Display the updated list size and last element
        System.out.println("Updated list size: " + myList.size());
        System.out.println("Last element after removal: " + myList.Last().getData());
        

    }
}
