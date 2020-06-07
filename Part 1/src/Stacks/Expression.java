package Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {

    private final List<Character> leftBrackets = Arrays.asList('(','<','{','[');
    private final List<Character> rightBrackets = Arrays.asList(')','>','}',']');

    public boolean isBalanced(String expression){
        Stack<Character> stack = new Stack<>();
        for (char ch: expression.toCharArray() ) {
            if (isOpeningBracket(ch))
                stack.push(ch);

            if (isClosingBracket(ch)) {
                if (stack.isEmpty()) return false;

                var top = stack.pop();
                if (bracketsMatch(ch, top)) return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean bracketsMatch(char right, Character left) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }

    private boolean isClosingBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    private boolean isOpeningBracket(char ch) {
        return rightBrackets.contains(ch);
    }
}
