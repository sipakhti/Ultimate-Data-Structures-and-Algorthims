package Stacks;

import java.util.EmptyStackException;

public class Stack {
    private int[] items;
    private int count;

    public Stack(){
        items = new int[1];
    }

    public void push(int number){
        if (isFull()) extendStack();

        items[count++] = number;

    }

    public int pop(){
        if (isEmpty()) throw new EmptyStackException();


        return items[--count];
    }

    public int peek(){
        if (isEmpty()) throw new EmptyStackException();

        return items[count -1];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    private boolean isFull() {
        return count == items.length;
    }

    private void extendStack(){
        int[] temp = new int[count * 2];
        for (int i = 0; i < count; i++)
            temp[i] = items[i];
        items = temp;
    }
}
