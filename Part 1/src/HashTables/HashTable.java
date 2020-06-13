package HashTables;

import LinkedList.LinkedList;

import java.awt.event.KeyEvent;

public class HashTable<K, V> {
    // put(k, v)
    // get(k): v
    // remove(k)
    // k: int
    // v: String
    // Collisions: chaining

    private class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }



    }

    private LinkedList<Entry<K,V>>[] list;

    public HashTable(){
        list = new LinkedList[10];
    }


    public boolean put(K key, V value){
        var entry = new Entry<K,V>(key,value);
        var index  = hash(key);
        LinkedList<Entry<K, V>> bucket = list[index];
        if (bucket == null) {
            list[index] = new LinkedList<Entry<K, V>>();
            list[index].addLast(entry);
            return true;
        }

        for (Entry<K, V> kvEntry : bucket)
            if (kvEntry.key == key) {
                kvEntry.value = value;
                return false;
            }


        bucket.addLast(entry);
        return true;
    }

    public V get(K key){
        var index = hash(key);
        var bucket = list[index];
        if (bucket == null)
            throw new IllegalArgumentException(String.format("'%d' is not a valid key or is not present",key));

        for (var entry : bucket)
            if (entry.key == key)
                return entry.value;

        return  null;
    }

    public void remove(K key){
        var index = hash(key);
        var bucket = list[index];
        if (bucket == null)
            throw new IllegalArgumentException(String.format("'%d' is not a valid key or is not present",key));

        list[index].deleteFirst();

    }

    private int hash(Object key){
        key = (int) Math.abs((int) key);
        return (int) key % list.length;
    }

    public static void main(String[] args) {
        HashTable<Integer,String> hashTable = new HashTable<>();
        hashTable.put(1,"Umer");
        hashTable.put(2,"Ali");
        hashTable.put(3,"Iqbal");
        System.out.println(hashTable.put(11,"Mehmood"));
        System.out.println(hashTable.put(3,"ABC"));
        System.out.println(hashTable.get(1));
        System.out.println(hashTable.get(11));
        System.out.println(hashTable.get(3));
    }
}
