package LinkedList;

import java.util.Arrays;



public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value, Node node){
            this.value = value;
            this.next = node;
        }
    }

    private Node first;
    private Node last;

    private int size;

    public LinkedList(){

    }

    public void addFirst(int val){

        first = new Node(val,first);
        if (isLast(first))
            last = new Node(0,first);
        size++;

    }

    public void addLast(int val){
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
            Node newNode = new Node(val,null);
            last.next.next = newNode; // last item
            last.next = newNode;
            size++;
        }
    }

    public void deleteFirst(){
        if (isEmpty())
            throw new EmptyList();

        Node tempNode = first.next;
        first.next = null;
        first = tempNode;
        size--;
        if (size == 0) last = null;

    }

    public void deleteLast(){
        Node currentNode = first;

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

    public int indexOf(int val){
        int index = 0;
        Node currentNode = first;
        if (isEmpty()) return -1;

        while(true){
            if (currentNode.value == val) return index;
            if (isLast(currentNode)) return -1;
            currentNode = currentNode.next;
            index++;
        }
    }

    public boolean contains(int val){
        return indexOf(val) != -1;
    }

    public int getSize() {
        return size;
    }

    public int[] toArray(){
        int[] items = new int[size];
        int index = 0;
        Node currentNode = first;

        while(index < size){
            items[index++] = currentNode.value;
            currentNode = currentNode.next;
        }

        return items;
    }

    public void reverse() {
        if (isEmpty()) return;

        Node previous = first;
        Node current = previous.next;
        while(current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        first.next = null;
        last.next = first;
        first = previous;
    }

    public int getKthFromTheEnd(int k){
        if (k > size || k < 1)
            throw new IllegalArgumentException();

        Node leading = first;
        Node trailing = first;
        for (int i = 0; i < k; i++)
            leading = leading.next;


        while(leading != null){
            leading = leading.next;
            trailing = trailing.next;
        }
        return trailing.value;
    }

    public void printMiddle(){
        Node leading = first;
        Node trailing = first;
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


    public void print(){
        Node currentNode = first;

        while(!isEmpty()){
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
            if (currentNode == null) break;

        }
    }

    private boolean isEmpty() {
        return first == null;
    }

    private boolean isLast(Node node) {
        return node.next == null;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.print();
        list.addFirst(10);
        System.out.println(list.getKthFromTheEnd(1));
        list.addLast(199);
        list.addLast(100);
        list.addFirst(29);
        list.addFirst(135956);
        list.addLast(999);
//        list.addLast(25);
        System.out.println(Arrays.toString(list.toArray()));
        list.reverse();
        System.out.println(Arrays.toString(list.toArray()));
        list.reverse();
        System.out.println(Arrays.toString(list.toArray()));
        list.printMiddle();
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
