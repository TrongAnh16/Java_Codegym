import java.util.Arrays;
import java.util.Scanner;

public class addElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        int i = 0;
        while (i < arr.length) {
            System.out.println("Enter an element " + (i + 1) + " is: ");
            arr[i] = sc.nextInt();
            i++;
        }

        System.out.println("Enter a value want to add: ");
        int trans = sc.nextInt();
        int index;
        do {
            System.out.println("Enter an index want to add: ");
            index = sc.nextInt();

            if (index < arr.length) {
                int[] arrNew = new int[arr.length + 1];
                for (i = 0; i < index; i++) {
                    arrNew[i] = arr[i];
                }
                arrNew[index] = trans;
                for (i = (index + 1); i < arrNew.length; i++) {
                    arrNew[i] = arr[i - 1];
                }
                System.out.println("Array before change: "+Arrays.toString(arr));
                System.out.println("Array after change: "+Arrays.toString(arrNew));
            } else {
                System.out.println("Index out of size array");
                index = -1;
            }
        } while (index == -1);
    }
}
