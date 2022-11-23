import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = (E[]) new Object[capacity];
    }

    private void ensureCapacity() {
        if (size > elements.length) {
            int minCapacity = size * 2;
            elements = Arrays.copyOf(elements, minCapacity);
        }
    }

    public void add(E element) {
        size++;
        ensureCapacity();
        elements[size - 1] = element;
    }

    public boolean add(E element, int index) {
        if (index >= 0 && index <= size) {
            size++;
            ensureCapacity();
            for (int i = size - 1; i >= index; i--) {
                elements[i+1] = elements[i];
            }
            elements[index] = element;
            return true;
        }
        return false;
    }
    public Object get(int index) {
        if (index >= 0 && index < size) {
            return elements[index];
        }
        return null;
    }
    @Override
    public MyList clone() {
        MyList<E> clone = new MyList<>(elements.length);
        for (Object x : elements) {
            clone.add((E) x);
        }
        return clone;
    }
    public E[] getElements() {
        return (E[]) this.elements;
    }
    public int size() {
        return size;
    }
    public boolean remove(int index) {
        if (index >= 0 && index < size) {
            for (int i=index;i<size;i++) {
                elements[i] = elements[i+1];
            }
            size--;
            return true;
        }
        return false;
    }
    public void clear() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    public int indexOf(E element) {
        for (int i =0; i<size;i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
    public boolean contains(E element) {
        for (Object x : elements) {
            if (element.equals(x)) {
                return true;
            }
        }
        return false;
    }
}

