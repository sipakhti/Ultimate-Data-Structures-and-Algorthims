package HashTables;

import com.sun.source.doctree.SeeTree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashTableExercises {


    public Object mostFrequent(Object[] items){
        HashTable<Object,Integer> hashTable = new HashTable<>();
        int max = 0;
        Object mostRepeated = null;

        for (Object item : items) {
            var count = hashTable.isKeyPresent(item) ? hashTable.get(item) : 0;
            hashTable.put(item,++count);
        }

        for (Object item : items) {
            var value = hashTable.get(item);
                if (value > max) {
                    max = value;
                    mostRepeated = item;
                }
        }

        return mostRepeated;

    }

    public int countPairsWithDiff(int[] items, int k){
        Set<Integer> set = new HashSet<>(items.length);
        for (int item : items)
            set.add(item);

        var count = 0;
        for (int item : items) {
            if (set.contains(item + k))
                count++;
            if (set.contains(item - k))
                count++;
            set.remove(item);
        }

        return count;
    }

    public int[] twoSum(int[] items, int target){
        HashTable<Integer,Integer> hashTable = new HashTable<>();

        for (int i = 0; i < items.length; i++) {
                var compliment = target - items[i];
                if (hashTable.isKeyPresent(compliment))
                    return new int[] {hashTable.get(compliment), i};

                hashTable.put(items[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        HashTableExercises test  = new HashTableExercises();
        System.out.println(test.mostFrequent(new Object[]{1,2,2,3,3,3,4}));
        System.out.println(test.countPairsWithDiff(new int[]{1,7,5,9,2,12,3}, 2));
        System.out.println(Arrays.toString(test.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
