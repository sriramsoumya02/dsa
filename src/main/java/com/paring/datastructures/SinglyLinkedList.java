package com.paring.datastructures;

public class SinglyLinkedList {
    private Node head;

    // Head is first node in linked list
    public boolean isEmpty() {
        return length() == 0;
    }

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        tail().next = new Node(data);
    }

    private Node tail() {
        Node tail = head;
        // Find last element of linked list known as tail
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }

    public int length() {
        int length = 0;
        Node current = head;
        // Starts counting from head - first node
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public Node getHead() {
        return this.head;
    }
}


