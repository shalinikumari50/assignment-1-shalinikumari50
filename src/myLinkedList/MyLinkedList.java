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

    public int insertInAlphabeticOrder(Node<T> newNode) {
        int position = 1;
        if (head == null || head.toString().toLowerCase().compareTo(newNode.toString().toLowerCase()) > 0) {
            newNode.setNext(head);
            setHead(newNode);
            return position;
        } else {
            Node<T> temp = head;
            while (temp.getNext() != null && temp.getNext().toString().toLowerCase().compareTo(newNode.toString().toLowerCase()) <= 0) {
                position++;
                temp = temp.getNext();
            }
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
        return ++position;
    }
}
