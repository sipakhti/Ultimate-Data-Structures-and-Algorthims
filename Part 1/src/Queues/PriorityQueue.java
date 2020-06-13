package Queues;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items;
    private int count, first, min;

    public PriorityQueue(){
        items = new int[5];
    }

    public void enqueue(int item){
        if (isFull()) extendQueue();

        items[shiftItemsToInsert(item)] = item;
        count++;
        }

    private int shiftItemsToInsert(int item) {
        int i;
        for  (i = count-1; i >= 0 ; i--)
            if (items[i] > item)
                items[i + 1] = items[i];
            else
                break;
        return i + 1;
    }


    public int dequeue(){
        if (isEmpty())
            throw new EmptyQueueException();

        return items[first++];
    }

    private void extendQueue() {
        items = Arrays.copyOf(items, count*2);
    }

    public boolean isFull() {
        return count == items.length;
    }

    public boolean isEmpty() {
        return count == first;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(items,first,count));
    }

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(5);
        queue.enqueue(40);
        queue.enqueue(15);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.dequeue());
    }
}
