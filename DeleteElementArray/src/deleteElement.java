import java.util.Arrays;
import java.util.Scanner;

public class deleteElement {
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
        System.out.println("Array before change: " + Arrays.toString(arr));
        int index = -1;
        int[] arrNew = new int[arr.length - 1];
        do {
            System.out.println("Enter an element want to delete: ");
            int ele_del = sc.nextInt();

            for (i = 0; i < arr.length; i++) {
                if (arr[i] == ele_del) {
                    index = i;
                    for (int j = 0; j < index; j++) {
                        arrNew[j] = arr[j];
                    }
                    for (int j = index; j < arrNew.length; j++) {
                        arrNew[j] = arr[j + 1];
                    }
                    System.out.println("Array after change: " + Arrays.toString(arrNew));
                }
            }
            if (index == -1) System.out.println("Not found element");
        } while (index == -1);
    }
}
