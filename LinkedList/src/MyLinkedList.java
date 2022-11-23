public class MyLinkedList<E> {
    private Node head;
    private int numNodes;
    private boolean flag;

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public MyLinkedList(Object data) {
        head = new Node(data);
    }

    public void add(int index, E element) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E element) {
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E element) {
        if (head == null) addFirst(element);
        else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = new Node(element);
        }
    }

    public void remove(int index) {
        Node temp = head;
        for (int i = index; i < index - 1 && temp.next != null; i++) {
            temp.next = temp.next.next;
        }
        numNodes--;
    }

    public void size() {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            temp = temp.next;
            i++;
        }
        System.out.println(i);
    }

    public void get(int index) {
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
            System.out.println(temp);

    }
    public boolean contains(Object data) {
        Node temp = head;
        for (int i =0;i<=numNodes;i++){
            if ((temp.data).equals(data)) {
                flag = true;
                break;
            }else {
                flag = false;
                temp = temp.next;
            }
        }
        return flag;
    }
    public int indexOf(Object data) {
        Node temp = head;
        int q = 0;
        for (int i = 0; i <= numNodes; i++) {
            if ((temp.data).equals(data)) {
                q = i;
                break;
            }else {
                temp = temp.next;
            }
        }
        return q;
    }

public void printList() {
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
}
}
