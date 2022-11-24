public class Test {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(1);
        list.add(1,2);
        list.add(2,"Luffy");
        list.add(3,4);
        list.add(4,5);
        list.addFirst(0);

        System.out.println(list.indexOf("Luffy"));
    }
}
