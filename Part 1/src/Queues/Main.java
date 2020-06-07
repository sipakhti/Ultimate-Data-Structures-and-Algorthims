package Queues;

import Stacks.Stack;

import java.util.ArrayDeque;
import java.util.Queue;


public class Main {
    public static void main(String[] args) {
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.add(10);
//        queue.add(20);
//        queue.add(30);
//        System.out.println(queue);
//        reverse(queue);
//        System.out.println(queue);

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(3);
        arrayQueue.add(100);
        arrayQueue.add(200);
        arrayQueue.add(300);
        System.out.println(arrayQueue);
        System.out.println(arrayQueue.remove());
        System.out.println(arrayQueue);
        arrayQueue.addFirst(500);
        System.out.println(arrayQueue);

        ArrayDeque<Integer> deque = new ArrayDeque<>();



    }

    public static void reverse(Queue<Integer> queue){
        Stack stack = new Stack();
        while (!queue.isEmpty())
            stack.push(queue.remove());

        while(!stack.isEmpty())
            queue.add(stack.pop());

    }



}
