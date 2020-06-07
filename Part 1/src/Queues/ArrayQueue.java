package Queues;

import Arrays.Array;

import java.util.Arrays;

public class ArrayQueue<T> {
    private Object[] items;
    private int first, last;
    private T t;

    public ArrayQueue(){
        items = new Object[10];
    }

    public ArrayQueue(int capacity){
        if (capacity <= 0)
            throw new IllegalArgumentException();
        items = new Object[capacity];
    }

    public void add(T item){
        if (isFull())
            throw new IllegalStateException("Que is Full!");

        items[last++] = item;
    }

    public void addFirst(T item){
        if (first == 0 && last == 0) {
            add(item);
            return;
        }
        else if (first == 0)
            throw new IllegalStateException("Cannot add new First Item");

        items[--first] = item;
    }


    public T remove(){
        if (isEmpty())
            throw new IllegalStateException("Que is Empty!");
        return (T) items[first++];
    }

    public T peek(){
        if (isEmpty()) return null;
        return (T) items[first];
    }

    public void clear(){
        first = last = 0;
    }

    public boolean isEmpty(){
        return first == last;
    }

    public boolean isFull(){
        return last == items.length;
    }



    @Override
    public String toString(){
        return Arrays.toString(Arrays.copyOfRange(items,first,last));
    }
}
