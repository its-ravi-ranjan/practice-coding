import java.util.LinkedList;

public class DoublyLinkedListInbuilt {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(34);
        list.add(45);
        list.add(24);
        System.out.println(list);
        list.remove(Integer.valueOf(45));
        list.addFirst(89);
        list.addLast(46);
        System.out.println(list);
        list.removeLast();
        // list.removeFirst();
        // list.addFirst(11);
        // list.addLast(22);
        System.out.println(list+""+list.size());
    }
}
