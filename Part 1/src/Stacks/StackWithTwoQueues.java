package Stacks;

import Queues.StackQueue;

import java.util.ArrayDeque;
import java.util.EmptyStackException;
import java.util.Queue;

public class StackWithTwoQueues {
    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();
    private int top;

    public void push(int item){
        queue1.add(item);
        top = item;
    }

    public int pop(){
        if (isEmpty())
            throw new EmptyStackException();
        while(queue1.size() > 1) {
            top = queue1.remove();
            queue2.add(top);
        }
        swapQueues();

        return queue2.remove();
    }

    public int peek(){
        return top;
    }

    public int size(){
        return queue1.size();
    }

    public boolean isEmpty(){
        if (isEmpty())
            throw new EmptyStackException();
        return queue1.isEmpty();
    }

    private void swapQueues() {
        var temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public static void main(String[] args) {
        StackWithTwoQueues stack = new StackWithTwoQueues();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack.pop());
    }
}
