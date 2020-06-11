package Queues;

import Arrays.Array;

import java.util.Arrays;

public class ArrayQueue<T> {
    private Object[] items;
    private int first, last, count;
    private T t;


    public ArrayQueue(int capacity){
        if (capacity <= 0)
            throw new IllegalArgumentException("Capacity can be less than 1");
        items = new Object[capacity];
    }

    public void add(T item){
        if (isFull())
            throw new FullQueueException();

        items[last] = item;
        last = (last + 1) % items.length;
        count++;
    }


    public T remove(){
        if (isEmpty())
            throw new EmptyQueueException();
        var item = items[first];
        items[first] = null;
        first = (first + 1) % items.length;
        count--;
        return (T) item;
    }

    public T peek(){
        if (isEmpty()) return null;
        return (T) items[first];
    }

    public void clear(){
        first = last = 0;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == items.length;
    }



    @Override
    public String toString(){
        return Arrays.toString(items);
    }
}
