public class LinkedList {

    Node head;

    // Inner class Node
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Add a node at the end of the list
    public void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
        }
    }

    // Add a node after a specific node
    public void addAfter(int after, int data) {
        Node node = new Node(data);
        Node curr = head;
        while (curr != null) {
            if (curr.data == after) {
                node.next = curr.next;
                curr.next = node;
                break;
            }
            curr = curr.next;
        }
    }

    // Add a node at the start of the list
    public void addStart(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    // Delete a node by value
    public void deleteSearch(int data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            if (curr.next.data == data) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    // Print the list
    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.printList(); // Output: 1 -> 2 -> 3 -> null

        list.addAfter(2, 4);
        list.printList(); // Output: 1 -> 2 -> 4 -> 3 -> null

        list.addStart(0);
        list.printList(); // Output: 0 -> 1 -> 2 -> 4 -> 3 -> null

        list.deleteSearch(2);
        list.printList(); // Output: 0 -> 1 -> 4 -> 3 -> null

        list.deleteSearch(0);
        list.printList(); // Output: 1 -> 4 -> 3 -> null
    }
}
