public class TheBigO {
    public static void main(String[] args) {
        System.out.println("TESTING");
    }

    public void constantO(int[] numbers){
        // O(1)
        /*
        NO matter how big the array is the time will always be constant
         */
        System.out.println(numbers[0]);
    }

    public void linearO(int[] numbers){
        // O(n)
        /*
        The cost of the algorithm increases proportionally to the input size
         */
        for (int number : numbers) {
            System.out.println(number);
        }
    }


    public void quadraticO(int[] numbers){
        // O(n ^ 2)
        /*
        with more nesting the power of n increases
         */
        for (int first: numbers) // O(n)
            for (int second: numbers) //O(n)
                System.out.println(first + ", " + second);

    }

    public void exponentialO(int[] numbers){

    }

    public void spaceComplexity(String[] names){
        // O(n) space
        String[] copy = new String[names.length];
        // O(1) spcae
        for (String name : names) {
            System.out.println("Hi " + name);
        }
    }
}
