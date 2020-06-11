package LinkedList;

import java.sql.ClientInfoStatus;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedList<T> implements Iterable<T>{


    private class myIterator<T> implements Iterator<T>{

        LinkedList<T>.Node<T> current;

        public myIterator(LinkedList<T> list){
            current = list.first;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            T item =  current.value;
            current = current.next;
            return  item;
        }
    }

    private class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> node){
            this.value = value;
            this.next = node;
        }
    }

    private Node<T> first;
    private Node<T> last;

    private int size;

    public LinkedList(){

    }

    public void addFirst(T val){

        first = new Node<T>(val,first);
        if (isLast(first))
            last = new Node<>(null,first);
        size++;

    }

    public void addLast(T val){
//        Node currentNode = first;
//        boolean isNull = false;
//
//
//        if (currentNode == null){
//            first = new Node(val, null);
//            last.setNext(currentNode);
//            isNull = true;
//        }
//        while(!isNull){
//            if (currentNode.getNext() == null) break;
//            currentNode = currentNode.getNext();
//
//        }
//        if (!isNull)
//            currentNode.setNext(new Node(val,null));
//        size++;



        if (isEmpty()) addFirst(val);
        else {
            Node<T> newNode = new Node<>(val,null);
            last.next.next = newNode; // last item
            last.next = newNode;
            size++;
        }
    }

    public void deleteFirst(){
        if (isEmpty())
            throw new EmptyList();

        Node<T> tempNode = first.next;
        first.next = null;
        first = tempNode;
        size--;
        if (size == 0) last = null;

    }

    public void deleteLast(){
        Node<T> currentNode = first;

        if (isEmpty())
            throw new EmptyList();

        if (isLast(currentNode)) {
            first = null;
            last.next = null;
        }
        while(!isLast(currentNode)){
            if (isLast(currentNode.next)) break;
            currentNode = currentNode.next;

        }
        if (!isLast(currentNode)) {
            currentNode.next = null;
            last.next = currentNode;
        }
        size--;

    }

    public int indexOf(T val){
        int index = 0;
        Node<T> currentNode = first;
        if (isEmpty()) return -1;

        while(true){
            if ((currentNode.value) == val) return index;
            if (isLast(currentNode)) return -1;
            currentNode = currentNode.next;
            index++;
        }
    }

    public boolean contains(T val){
        return indexOf(val) != -1;
    }

    public int getSize() {
        return size;
    }

    public Object[] toArray(){
        Object[] items = new Object[size];
        int index = 0;
        Node<T> currentNode = first;

        while(index < size){
            items[index++] = currentNode.value;
            currentNode = currentNode.next;
        }

        return items;
    }

    public void reverse() {
        if (isEmpty()) return;

        Node<T> previous = first;
        Node<T> current = previous.next;
        while(current != null) {
            Node<T> next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        first.next = null;
        last.next = first;
        first = previous;
    }

    public T getKthFromTheEnd(int k){
        if (k > size || k < 1)
            throw new IllegalArgumentException();

        Node<? extends T> leading = first;
        Node<T> trailing = first;
        for (int i = 0; i < k; i++)
            leading = leading.next;


        while(leading != null){
            leading = leading.next;
            trailing = trailing.next;
        }
        return trailing.value;
    }

    public void printMiddle(){
        if (isEmpty())
            throw new IllegalStateException();
        Node<? extends T> leading = first;
        Node<T> trailing = first;
        int pass = 1;

        while (!isLast(leading)){
            for (int i = 0; i < pass; i++)
                leading = leading.next;
            if (leading == null) break;
            trailing = trailing.next;
            pass++;
        }
        if (leading == null)
            System.out.println(trailing.value + " , " + trailing.next.value);
        else
            System.out.println(trailing.value);
    }

    public T getFirst(){
        return first.value;
    }

    public T getLast(){
        return last.next.value;
    }

    public void print(){
        Node<T> currentNode = first;

        while(!isEmpty()){
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
            if (currentNode == null) break;

        }
    }

    private boolean isEmpty() {
        return first == null;
    }

    private boolean isLast(Node<? extends T> node) {
        return node.next == null;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {
        return new myIterator<T>(this);
    }


    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.print();
        list.addFirst("10");
        System.out.println(list.getKthFromTheEnd(1));
        list.addLast("199");
        list.addLast("100");
        list.addFirst("29");
        list.addFirst("135956");
        list.addLast("999/n125/n654694");

        LinkedList<Integer> integerLinkedList = new LinkedList<Integer>();

//        list.addLast(25);
//        System.out.println(Arrays.toString(list.toArray()));
//        list.reverse();
//        System.out.println(Arrays.toString(list.toArray()));
//        list.reverse();
//        System.out.println(Arrays.toString(list.toArray()));
//        list.printMiddle();
//        System.out.println(list.indexOf(1234));
//        System.out.println(list.contains(999));
//        System.out.println(list.contains(500));
//        list.deleteFirst();
//        list.print();
//        list.deleteLast();
//        list.deleteLast();
//        list.deleteLast();
//        list.print();
//        list.print();
//        list.deleteLast();
//        System.out.println(list.contains(334));
//        System.out.println(list.contains(500));
//        list.print();
//        System.out.println(Arrays.toString(list.toArray()));
//        System.out.println(list.getSize());
//        list.deleteFirst();
//        list.contains(155);
//        list.indexOf(155);
//        list.addFirst(200);
//        list.addLast(500);
//        list.print();
//        list.deleteFirst();
//        list.reverse();
//        System.out.println(Arrays.toString(list.toArray()));



    }

}
