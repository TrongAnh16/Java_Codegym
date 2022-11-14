import java.time.LocalTime;

public class Main {
    public static int[] selectionSort(int... a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[100000];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 100000);
        }
        LocalTime start = LocalTime.now();
        a = selectionSort(a);
        LocalTime end = LocalTime.now();
        stopWatch sw = new stopWatch(start, end);
        System.out.println("Time: " + sw.getElapsedTime());
        for (int x : a) {
            System.out.println(x);
        }
    }
}
