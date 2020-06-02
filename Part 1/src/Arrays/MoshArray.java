package Arrays;

public class MoshArray {
    int[] items;
    int count;

    public MoshArray(int length){
        items = new int[length];
    }

    public void insert(int item){
        if (items.length == count){
            int[] newitems = new int[count*2];

            for (int i = 0; i < count ; i++)
                newitems[i] = items[i];

            items = newitems;
        }
        items[count++] = item;
    }

    public void removeAt(int index){
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();
    }

    public void print(){
        for (int i = 0; i < count; i++) {
            System.out.println(items[0]);
        }
    }
}
