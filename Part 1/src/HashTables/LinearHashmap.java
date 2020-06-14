package HashTables;

import java.lang.invoke.StringConcatFactory;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class LinearHashmap<K,V> {

    private class Entry<K,V> {
        private K key;
        private V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private Entry<K,V>[] items;
    private int size;

    public LinearHashmap(){
        items = new Entry[10];
    }

    public boolean put(K key, V value){
        var node = new Entry<K, V>(key, value);
        var index = hash(key);
        if (items[index] == null) {
            items[index] = node;
            size++;
            return true;
        }
        if (isFull()) extendArray();

        items[getIndex(key)] = node;
        size++;
        return true;

    }

    public V get(K key){
        var index = getIndex(key);
       var node = index >= 0 ? items[index] : null;
       if (node == null)
           return null;
       return node.value;
    }

    public void remove(K key){
        var index = getIndex(key);
        if (index == -1 || items[index] == null)
            return;

        items[index] = null;
        size--;
    }

    public int size(){
        return size;
    }

    private boolean isFull(){
        return size == items.length;
    }


    private int hash(K key){
        if (key instanceof Number)
        {
            var temp = Math.abs((int) key);
            return temp % items.length;
        }
        if (key instanceof String){
            var temp = ((String) key).toCharArray();
            int index = 0;
            for (char c : temp)
                index += c;
            return index % items.length;
        }
        if (key == null)
            return new Random(123456789).nextInt() % items.length;
        return -1;
    }

    private int linearHash(K key, int i){
        return (hash(key) + i) % items.length;
    }

    private int getIndex(K key){
        int tries = 0;

        while (tries < items.length){
            var index = linearHash(key,tries++);
            var node = items[index];
            if (node == null || node.key == key)
                return index;
        }
        return -1;
    }

    private void extendArray(){
        var temp = new Entry[items.length * 2];
        System.arraycopy(items, 0, temp, 0, items.length);
        items = temp;
    }

    @Override
    public String toString(){
        String[] keys = new String[size];
        int count = 0;
        for (int i = 0; i < items.length; i++)
            if (items[i] != null)
                keys[count++] =(String) items[i].key;

        return Arrays.toString(keys);
    }

    public static void main(String[] args) {
        LinearHashmap<String, Integer> map = new LinearHashmap<>();
        map.put("Umer",10);
        map.put("Hassan",20);
        map.put("Qamar",30);
        map.put("Qamr",30);
        map.put("Qaar",30);
        map.put("Qmar",30);
        map.put("Qamkar",30);
        map.put("Qamcvkjar",30);
        map.put("Qamzsfhar",30);
        map.put("Qamgdzar",30);
        map.put("Umfasdfer",10);
        map.put("Hafasdafssan",20);
        map.put("Qamadfsgfar",30);
        map.put("Qadgdfshsdggmr",30);
        map.put("Qasgadfgafdgdar",30);
        map.put("dgdfagagf",30);
        map.put("Qamasgdafkar",30);
        map.put("Qamagsgdfcvkjar",30);
        map.put("Qamzsasgfhar",30);
        map.put("Qagfagmgdzar",30);
        map.put("Qamdfagsagdar",30);
        System.out.println(map);
        System.out.println(map.get("Qamar"));
        map.put("Qamar",500);
        System.out.println(map.get("Qamar"));
        map.remove("Qamar");
        System.out.println(map.get("Qamar"));



    }
}
