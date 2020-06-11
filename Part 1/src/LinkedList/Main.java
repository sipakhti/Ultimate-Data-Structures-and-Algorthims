package LinkedList;


public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
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
