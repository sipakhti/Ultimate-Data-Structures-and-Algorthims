package Stacks;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class DualStack {
    private int[] items;
    private int count1 = 0, count2 = 1;
    private Stack<Integer> min1, min2;

    public DualStack(){
        items = new int[10];
        min1 = new Stack<>();
        min2 = new Stack<>();
    }

    public void push1(int item){
        if (isFull1()) extendStack();

        if (isEmpty1())
            min1.push(item);
        else if (item < min1.peek())
            min1.push(item);

        items[count1] = item;
        count1+=2;
    }

    public void push2(int item){
        if (isFull2()) extendStack();

        if (isEmpty2())
            min2.push(item);
        else if (item < min2.peek())
            min2.push(item);

        items[count2] = item;
        count2+=2;
    }

    public int pop1(){
        stack1Exception();

        count1-= 2;
        if (items[count1] == min1.peek())
            min1.pop();

        return items[count1];
    }

    public int pop2(){
        stack2Exception();

        count2-= 2;
        if (items[count2] == min2.peek())
            min2.pop();

        return items[count2];
    }

    public int peek1(){
        stack1Exception();
        return items[count1 - 2];
    }

    public int peek2(){
        stack2Exception();
        return items[count2 - 2];
    }

    public boolean isEmpty1(){
        return count1 == 0;
    }

    public boolean isEmpty2(){
        return count2 == 1;
    }

    public boolean isFull1(){
        return count1 == items.length - 2;
    }

    public boolean isFull2(){
        return count2 == items.length - 1;
    }

    public int min1(){
        return min1.peek();
    }

    public int min2(){
        return min2.peek();
    }

    private void extendStack(){
        int[] temp = new int[items.length * 2];
        for (int i = 0; i < items.length; i++)
            temp[i] = items[i];
        items = temp;
    }

    private void stack1Exception() {
        if (isEmpty1())
            throw new EmptyStackException();
    }

    private void stack2Exception() {
        if (isEmpty2())
            throw new EmptyStackException();
    }

    @Override
    public String toString(){
        return Arrays.toString(items) + (count1+count2);
    }
}
