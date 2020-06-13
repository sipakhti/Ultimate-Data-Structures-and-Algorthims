package Sets;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        int firstrepeat = 0;
        int[] numbers = {1,2,3,3,4,5,2,5,6,7};
        for (var number : numbers)
            if (!set.add(number)) {
                firstrepeat = number;
                break;
            }


        System.out.println(firstrepeat);

    }
}
