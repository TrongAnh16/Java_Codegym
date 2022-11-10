import java.util.Scanner;

public class minValue {

    public static int min(int[] arr) {
        int min = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        return min;
    }

    public static int position(int[] arr) {
        int min = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        System.out.println("Enter a size array: ");
        size = sc.nextInt();
        int[] array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.println("Enter an " + (i + 1) + ":");
            array[i] = sc.nextInt();
            i++;
        }

        int a = min(array);
        int b = position(array);
        System.out.print("Min value is: " + a + " ");
        System.out.print("at index: " + b);
    }
}
