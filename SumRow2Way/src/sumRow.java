import java.util.Scanner;

public class sumRow {
    public static int sumRowArr2Way(int[][] arr) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        System.out.println("Enter a column want to sum: ");
        int column = sc.nextInt();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][column];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr;
        System.out.println("Enter number of rows: ");
        int row = sc.nextInt();
        System.out.println("Enter number of column: ");
        int col = sc.nextInt();
        arr = new int[row][col];
        for (row = 0; row < arr.length; row++) {
            for (col = 0; col < arr[row].length; col++) {
                System.out.println("Enter a element at [" + row + "][" + col + "] : ");
                arr[row][col] = sc.nextInt();
            }
        }
        System.out.println("Sum of column your choice is: " +sumRowArr2Way(arr));
    }
}
