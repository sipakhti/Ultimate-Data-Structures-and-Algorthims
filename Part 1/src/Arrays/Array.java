package Arrays;

import java.util.Arrays;

public class Array {


    private int[] items;
    private int count;

    public Array(){
        items = new int[1];
    }

    public Array(int length){
        items = new int[length];
    }

//    public Array(int[] item){
//        this.items = item;
//    }

    // O(n)
    public void insert(int item){
        if (items.length == count){
            int[] tempArray = new int[count * 2];

            for (int i = 0; i < count; i++)
                tempArray[i] = items[i];

            items = tempArray;
        }
        items[count++] = item;
    }

    /**
     * <p>removes the element at the specified index</p>
     * @param index - the specified index
     */
    // O(n)
    public void removeAt(int index){
        if (index < 0 || index >= count)
            throw new IllegalArgumentException("Index not in range");
        for (int i = index; i < count; i++) {
            items[i] = items[i+1];
        }
        count--;
    }

    /**
     *
     * @param item the number you want searched
     * @return the index of the first occurrence of <b>number</b>
     *         <p>return -1 if no match found</p>
     */
    // O(n)
    public int indexOf(int item){
        for (int i = 0; i < count; i++) {
            if (items[i] == item) return i;
        }

        return -1;
    }

    /**
     *
     * @return - biggest integer in the Array
     */
    // O(n)
    public int max(){
        int max = 0;
        for (int i = 0; i < count; i++)
            if (items[i] > max)
                max = items[i];

        return max;
    }

    /**
     *<p>
     *     Finds all the elements that are present in the passed array
     *     and itself and reutrns them as another array
     *</p>
     * @param a - the list to be compared
     * @return - a list containing overlapping elements of the both list
     * similar to intersection is sets
     */
    // O(n ^ 2)
    public int[] intersect(int[] a){
        Array intersect = new Array();
        for (int i = 0; i < count; i++) {
            for (int value : a) {
                if (items[i] == value) {
                    intersect.insert(value);
                    break;
                }
            }
        }
        return intersect.toArray();
    }

    /**
     * Reverses the order of the elements within the array
     */
    // O(n)
    public void reverse(){
        int[] tempArray = new int[count];
        for (int i = 0; i < count; i++)
            tempArray[i] = items[count - i - 1];

        for (int i = 0; i < count; i++)
            items[i] = tempArray[i];

    }

    /**
     * <p>
     *     inserts the item at the passed index and shifts all the rest of the elements by 1
     * </p>
     * @param item - the item that is to be inserted
     * @param index - the index at which the item is to be inserted
     */
    // O(n)
    public void insertAt(int item, int index){
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        if (items.length == count)
            this.insert(0);


        for (int i = count; i >= index; i--)
            items[i] = items[i-1];

        items[index] = item;
        count++;
    }

    /**
     * prints all the elements to the console
     */
    public void print(){
        for (int i = 0; i < count;i++) {
            System.out.print(items[i] + " ");
        }

    }

    /**
     *  some methods might require an array to be passed as an argument thus this method
     *  is used to return an array representation of the dynamic array
     * @return - the array of all values
     */
    public int[] toArray(){
        if (items.length == count) return items;

        int[] currentArray = new int[count];
        System.arraycopy(items, 0, currentArray, 0, count);

        return currentArray;
    }

    @Override
    public String toString() {
        return  Arrays.toString(items);
    }
}
