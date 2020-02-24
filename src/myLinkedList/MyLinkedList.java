package myLinkedList;

import node.Node;

public class MyLinkedList<T> {
    private Node<T> head;

    public MyLinkedList() {
        head = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
}
