package LinkedList;

public class LinkedList {
    private Node first;
    private Node last;
    private int size;

    public LinkedList(){

    }

    public void addFirst(int val){

        first = new Node(val,first);
        size++;

    }

    public void addLast(int val){
        Node currentNode = first;
        boolean isNull = false;

        if (currentNode == null){
            first = new Node(val, null);
            isNull = true;
        }
        while(!isNull){
            if (currentNode.getNext() == null) break;
            currentNode = currentNode.getNext();

        }
        if (!isNull)
            currentNode.setNext(new Node(val,null));
        size++;
    }

    public void deleteFirst(){
        Node tempNode = first.getNext();
        first.deleteNode();
        first = tempNode;
        size--;
    }

    public void deleteLast(){
        Node currentNode = first;
        boolean isLast = false;

        if (currentNode.getNext() == null) {
            isLast = true;
            first = null;
        }
        while(!isLast){
            if (currentNode.getNext().getNext() == null) break;
            currentNode = currentNode.getNext();

        }
        if (!isLast)
            currentNode.deleteNode();
        size--;
    }

    public boolean contains(int val){
        Node currentNode = first;
        if (currentNode == null) return false;

        while (true){
            if (currentNode.getValue() == val) return true;
            if (currentNode.getNext() == null) return false;
            currentNode = currentNode.getNext();
        }
    }

    public int indexOf(int val){
        int index = 0;
        Node currentNode = first;
        if (currentNode == null) return -1;

        while(true){
            if (currentNode.getValue() == val) return index;
            if (currentNode.getNext() == null) return -1;
            currentNode = currentNode.getNext();
            index++;
        }
    }

    public int getSize() {
        return size;
    }

    public void print(){
        Node currentNode = first;
        boolean isEmpty = false;

        if (currentNode == null) isEmpty = true;
        while(!isEmpty){
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNext();
            if (currentNode == null) break;

        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(10);
        list.addLast(199);
        list.addLast(100);
        list.addFirst(29);
        list.addFirst(135956);
        list.addLast(999);
        list.print();
        System.out.println(list.indexOf(135956));
        System.out.println(list.contains(999));
        System.out.println(list.contains(500));
        list.deleteFirst();
        list.print();
        list.deleteLast();
        list.deleteLast();
        list.deleteLast();
        list.print();
        list.addFirst(500);
        list.print();
        list.deleteLast();
        list.addLast(334);
        System.out.println(list.contains(334));
        System.out.println(list.contains(500));
        list.print();
        System.out.println(list.getSize());

    }

}
