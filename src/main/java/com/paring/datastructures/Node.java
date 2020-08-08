package com.paring.datastructures;

// Node is nested class because it only exists along with linked list
// Node is private because it's implementation detail
public class Node {
    public Node next;
    public int data;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return this.data + "";
    }
}
