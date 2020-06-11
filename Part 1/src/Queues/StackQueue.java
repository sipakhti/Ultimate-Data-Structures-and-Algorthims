package Queues;

import java.util.Stack;

public class StackQueue<E> {
    private Stack<E> bufferStack, queStack;

    public StackQueue(){
        bufferStack = new Stack<>();
        queStack = new Stack<>();

    }

    public void enqueue(E item){

        bufferStack.push(item);

    }

    public E dequeue(){
        if (isEmpty())
            throw new EmptyQueueException();

        moveStack1toStack2();

        return queStack.pop();
    }

    public E peek(){
        if (isEmpty())
            throw new EmptyQueueException();

        moveStack1toStack2();

        return queStack.peek();
    }


    public boolean isEmpty(){
        return bufferStack.isEmpty() && queStack.isEmpty();
    }

    private void moveStack1toStack2() {
        if (queStack.isEmpty())
            while (!bufferStack.isEmpty())
                queStack.push(bufferStack.pop());
    }

    @Override
    public String toString() {
        return "StackQueue{" +
                "bufferStack=" + bufferStack +
                ", queStack=" + queStack +
                '}';
    }



    public static void main(String[] args) {
        StackQueue<Integer> queue = new StackQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(50);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.dequeue();
        System.out.println(queue);
    }
}
