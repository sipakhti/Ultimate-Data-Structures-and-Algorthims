package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
//        int[] numbers = new int[3];
//        // OR
//        int[] numbers2 = {10,20,30};
//        System.out.println(Arrays.toString(numbers));
//        System.out.println(numbers.length);

        Array numbers = new Array(2);
        numbers.insert(1);
        numbers.insert(2);
        numbers.insert(3);
        numbers.insert(4);
        numbers.insert(10);
        numbers.insert(20);
//        numbers.removeAt(1);
//        numbers.print();
        System.out.println(numbers.indexOf(12));
        System.out.println(numbers.max());
//        System.out.println(Arrays.toString(numbers.intersect(new int[]{3,7,9,10,51,12})));
        numbers.print();
        numbers.reverse();
        numbers.print();
        numbers.reverse();
        numbers.print();
        numbers.insertAt(1000,2);
        numbers.print();
        System.out.println(Arrays.toString(numbers.toArray()));

        // JAVA HAS INBULIT CLASSES THAT ACT AS DYNAMIC ARRAYS
        Vector<Integer> vector = new Vector<>(); // increase 100% of its size when full
        ArrayList<Integer> arrayList = new ArrayList<>(); // increase 50% of its size when full
    }
}
