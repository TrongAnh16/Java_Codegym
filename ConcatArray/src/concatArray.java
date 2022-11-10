import java.util.Arrays;
import java.util.Scanner;

public class concatArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size1 = 0;
        int[] arr1 = new int[3];
        System.out.println("Enter array 1: ");
        while (size1 < arr1.length) {
            System.out.println("Enter an element at index: "+size1);
            arr1[size1] = sc.nextInt();
            size1++;
        }
        int size2 = 0;
        int[] arr2 = new int[3];
        System.out.println("Enter array 2: ");
        while (size2 < arr2.length) {
            System.out.println("Enter an element at index: "+size2);
            arr2[size2] = sc.nextInt();
            size2++;
        }

        int[] arr3 = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr3.length - arr1.length; i++) {
            arr3[i] = arr1[i];
        }
        for (int j = arr2.length; j < arr3.length; j++) {
            arr3[j] = arr2[j - arr2.length];
        }
        System.out.println("Array 3 is concat array1 + array 2");
        System.out.println("Array 3 is: "+Arrays.toString(arr3));
    }
}
