package Queues;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedListQueue {
    private class Node {
        private int value;
        private Node next;

        public Node(int value){ this.value = value;}
    }

    private Node head, tail;
    private int size;

    // O(1)
    public void enqueue(int item){
        var node = new Node(item);

        if (isEmpty())
            tail = head = node;
        else {
            tail.next = node;
            tail = tail.next;
        }
        size++;
    }

    //O(1)
    public int dequeue(){
        if (isEmpty())
            throw new EmptyQueueException();

        var value = head.value;
        var second = head.next;
        head.next = null;
        head = second;
        size--;

        return value;
    }

    public int peek(){
        if (isEmpty())
            throw new EmptyQueueException();

        return head.value;
    }

    //O(1)
    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }


    //O(n)
    @Override
    public String toString() {
        ArrayList<Integer> list =  new ArrayList<>();
        var current = head;
        while(isLast(current)){
            list.add(current.value);
            current = current.next;
        }
        return list.toString();
    }

    private boolean isLast(Node current) {
        return current != null;
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());



    }
}
