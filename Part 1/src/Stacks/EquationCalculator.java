package Stacks;

import java.util.Stack;

public class EquationCalculator {
    private Stack<Character> equationStack;
    private int total;

    public EquationCalculator(){
        equationStack = new Stack<>();
    }

    public int calculate(String equation){

        for (char ch: equation.toCharArray())
            equationStack.push(ch);

        while (!equationStack.isEmpty()){
            StringBuffer value1 = new StringBuffer();
            StringBuffer value2 = new StringBuffer();
            if (isNumber())
                value2.append(equationStack.pop());
            switch (equationStack.peek()) {
                case '/':
                    equationStack.pop();
                    while (isNumber())
                        value1.append(equationStack.pop());
                    divide(value1, value2);
                    break;

                case '*':
                    equationStack.pop();
                    while (isNumber())
                        value1.append(equationStack.pop());
                    multiply(value1, value2);
                    break;

                case '+':
                    equationStack.pop();
                    while (isNumber())
                        value1.append(equationStack.pop());
                    add(value1, value2);
                    break;

                case '-':
                    equationStack.pop();
                    while (isNumber())
                        value1.append(equationStack.pop());
                    subtract(value1, value2);
                    break;
            }

        }
        return total;
    }

    private void subtract(StringBuffer value1, StringBuffer value2) {
        if (value2.length() == 0)
            value2.append(0);
        total += Integer.parseInt(value1.toString()) - Integer.parseInt(value2.toString());
    }

    private void add(StringBuffer value1, StringBuffer value2) {
        if (value2.length() == 0)
            value2.append(0);
        total += Integer.parseInt(value1.toString()) + Integer.parseInt(value2.toString());
    }

    private void multiply(StringBuffer value1, StringBuffer value2) {
        if (value2.length() == 0)
            value2.append(0);
        total += Integer.parseInt(value1.toString()) * Integer.parseInt(value2.toString());
    }

    private void divide(StringBuffer value1, StringBuffer value2) {
        if (value2.length() == 0)
            value2.append(0);
        total += Integer.parseInt(value1.toString()) / Integer.parseInt(value2.toString());
    }

    private boolean isNumber(){
        if (equationStack.isEmpty()) return false;
        else return (int) equationStack.peek() >= 48 && (int) equationStack.peek() <= 57;
    }
}
