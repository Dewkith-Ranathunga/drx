public class DoublyLinkedList {

    Node head;

    // Inner class Node
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Add a node at the end of the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.prev = curr;
        }
    }

    // Add a node after a specific node
    public void addAfter(int after, int data) {
        Node newNode = new Node(data);
        Node curr = head;
        while (curr != null) {
            if (curr.data == after) {
                newNode.next = curr.next;
                newNode.prev = curr;
                if (curr.next != null) {
                    curr.next.prev = newNode;
                }
                curr.next = newNode;
                break;
            }
            curr = curr.next;
        }
    }

    // Add a node at the start of the list
    public void addStart(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    // Delete a node by value
    public void deleteSearch(int data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        Node curr = head;
        while (curr != null) {
            if (curr.data == data) {
                if (curr.prev != null) {
                    curr.prev.next = curr.next;
                }
                if (curr.next != null) {
                    curr.next.prev = curr.prev;
                }
                return;
            }
            curr = curr.next;
        }
    }

    // Print the list
    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " <-> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.printList(); // Output: 1 <-> 2 <-> 3 <-> null

        list.addAfter(2, 4);
        list.printList(); // Output: 1 <-> 2 <-> 4 <-> 3 <-> null

        list.addStart(0);
        list.printList(); // Output: 0 <-> 1 <-> 2 <-> 4 <-> 3 <-> null

        list.deleteSearch(2);
        list.printList(); // Output: 0 <-> 1 <-> 4 <-> 3 <-> null

        list.deleteSearch(0);
        list.printList(); // Output: 1 <-> 4 <-> 3 <-> null
    }
}
