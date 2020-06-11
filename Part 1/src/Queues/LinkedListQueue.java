package Queues;

import LinkedList.LinkedList;

import java.util.Arrays;

public class LinkedListQueue<T> {
    private LinkedList<T> list;
    private int maxSize, count;


    public LinkedListQueue(int capacity){
        list = new LinkedList<T>();
        maxSize = capacity;
    }

    public void add(T item){
        if (isFull())
            throw new FullQueueException();

        list.addLast(item);
        count++;
    }

    public T remove(){
        if (isEmpty())
            throw new EmptyQueueException();

        T item = list.getFirst();
        list.deleteFirst();
        count--;
        return item;
    }

    private boolean isEmpty() {
        return count == 0;
    }

    public T peek(){
        return list.getFirst();
    }

    public boolean isFull(){
        return count == maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public String toString() {
        return Arrays.toString(list.toArray());
    }

    public static void main(String[] args) {
        var que = new LinkedListQueue<Integer>(5);
        que.add(100);que.add(20);que.add(55);que.add(200);que.add(300);
        System.out.println(que);
        System.out.println(que.isFull());
        System.out.println(que.remove());
        System.out.println(que);
        System.out.println(que.peek());

    }
}
