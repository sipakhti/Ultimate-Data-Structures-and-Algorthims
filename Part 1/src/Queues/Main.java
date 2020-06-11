package Queues;

import Stacks.Stack;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
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
//
//        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(5);
//        arrayQueue.add(100);
//        arrayQueue.add(200);
//        arrayQueue.add(300);
//        arrayQueue.add(400);
//        arrayQueue.add(500);
//        System.out.println(arrayQueue);
//        System.out.println(arrayQueue.remove());
//        System.out.println(arrayQueue.remove());
//        System.out.println(arrayQueue);
//        arrayQueue.add(600);
//        System.out.println(arrayQueue);
//        ArrayDeque<Integer> deque = new ArrayDeque<>();

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);



    }

    public static void reverse(Queue<Integer> queue){
        Stack stack = new Stack();
        while (!queue.isEmpty())
            stack.push(queue.remove());

        while(!stack.isEmpty())
            queue.add(stack.pop());

    }



}
