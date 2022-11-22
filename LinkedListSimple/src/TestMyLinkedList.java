public class TestMyLinkedList {
    public static void main(String[] args) {
        System.out.println("-----TESTING---------");
        MyLinkedList linkedList = new MyLinkedList(20);
        linkedList.addFirst(11);
        linkedList.addFirst(12);
        linkedList.addFirst(53);

        linkedList.add(4,1);
        linkedList.add(4,99);
        linkedList.printList();
    }
}
