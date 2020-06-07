package Stacks;

import java.util.Stack;

public class StringReverser {

    public String reverser(String input){
        StringBuffer reversed = new StringBuffer();
        Stack<Character> stack = new Stack<>();

        for (char ch: input.toCharArray())
            stack.push(ch);

        while(!stack.empty())
            reversed.append(stack.pop());
        return reversed.toString();
    }
}
