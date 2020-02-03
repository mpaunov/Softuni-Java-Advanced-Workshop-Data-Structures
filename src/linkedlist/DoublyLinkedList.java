package linkedlist;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public int size() {
        return this.size;
    }

    private static class Node {
        private Node prev;
        private Node next;
        private int element;

        public Node(int element) {
            this.element = element;
        }

        public Node(Node prev, Node next, int element) {
            this(element);
            this.prev = prev;
            this.next = next;
        }
    }

    public DoublyLinkedList() {
    }

    public void addLast(int element) {
        this.size++;
        Node newNode = new Node(element);

        if (this.tail == null) {
            this.head = this.tail = newNode;
            return;
        }

        newNode.prev = this.tail;
        this.tail.next = newNode;
        this.tail = newNode;
    }

    public void addFirst(int element) {
        if (this.head == null) {
            this.addLast(element);
            return;
        }
        this.size++;
        Node newNode = new Node(element);

        newNode.next = this.head;
        this.head.prev = newNode;
        this.head = newNode;
    }

    public int removeLast() {
        if (this.size == 0) {
            throw new IllegalStateException("Illegal remove called on empty list");
        }

        int element = this.tail.element;

        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next.prev = null;
            this.tail.next = null;
        }

        this.size--;
        return element;
    }

    public int removeFirst() {
        if (this.size <= 1) {
            return this.removeLast();
        }

        int element = this.head.element;

        Node currentNode = this.head;

        this.head = new Node(null, this.head.next.next, this.head.next.element);

        currentNode.next = null;

        this.size--;

        return element;
    }

    public boolean insertAfter(int nodeValue, int element) {

        Node current = this.head;

        while (current != null) {
            if (current.element == nodeValue) {
                if (current.next == null) {
                    this.addLast(element);
                    return true;
                } else {
                    this.size++;
                    Node newNode = new Node(current, current.next, element);
                    current.prev = current.next.prev;
                    current.next.prev = newNode;
                    current.next = newNode;
                    return true;
                }
            }
            current = current.next;
        }

        return false;
    }
}
