package Queues;

import java.awt.event.TextEvent;
import java.util.Arrays;

public class PriorityQueue {
    private int[] items;
    private int count, first, min;

    public PriorityQueue(){
        items = new int[5];
    }

    public void enqueue(int item){
        if (isFull()) extendQueue();


        for (int i = items.length-1; i >= 0 ; i--) {
            if (items[i] > item)
                items[i + 1] = items[i];
            else if (items[i] <= item && items[i] != 0) {
                items[i + 1] = item;
                break;
            }
        }
        if (isEmpty())
            items[0] = item;

        count++;

    }

    public int dequeue(){
        if (isEmpty())
            throw new EmptyQueueException();

        return items[first++];
    }

    private void extendQueue() {
        items = Arrays.copyOf(items, count*2);
    }

    private boolean isFull() {
        return count == items.length;
    }

    private boolean isEmpty() {
        return count == first;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(5);
        queue.enqueue(40);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
    }
}
