package Queues;

import java.util.Arrays;
import java.util.Stack;

public class QueueReverser {
    private int[] items;

    public QueueReverser(int[] queue){
        items = queue;
    }

    public int[] reverse(int k){
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++)
            stack.push(items[i]);
        for (int i = 0; i < k; i++)
            items[i] = stack.pop();

        return items;
    }

    public static void main(String[] args) {
        int[] que = {10,20,30,40,50};
        QueueReverser queueReverser = new QueueReverser(que);
        System.out.println(Arrays.toString(queueReverser.reverse(3)));
    }
}
