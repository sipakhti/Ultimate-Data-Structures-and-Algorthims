package Stacks;



public class Main {

    public static void main(String[] args) {
//
//        var reverser = new StringReverser();
//        var resersed = reverser.reverser("UMER");
//        System.out.println(resersed);
//
//        System.out.println((int) 'a');
//
//        EquationCalculator calculator = new EquationCalculator();
//        int answer = calculator.calculate("10/2");
//        System.out.println(answer);
//
//        Expression expression = new Expression();
//        boolean foo = expression.isBalanced("(1+2+3)");
//        System.out.println(foo);


//        Stack stack = new Stack();
//
//        for (int i = 1; i <= 100; i++) {
//            stack.push(i*10);
//        }
//
//        System.out.println(stack.peek());

        DualStack dualStack = new DualStack();
        dualStack.push1(10);
        dualStack.push1(20);
        dualStack.push1(25);
        dualStack.push1(5);
        System.out.println(dualStack);
        dualStack.push2(100);
        dualStack.push2(200);
        dualStack.push2(250);
        dualStack.push2(50);
        System.out.println(dualStack.min1());
        System.out.println(dualStack.min2());
        dualStack.pop1();
        System.out.println(dualStack);
        dualStack.pop2();
        System.out.println(dualStack.min1());
        System.out.println(dualStack.min2());






    }
}