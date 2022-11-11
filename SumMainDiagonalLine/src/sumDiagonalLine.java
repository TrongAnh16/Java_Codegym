import java.util.Scanner;

public class sumDiagonalLine {
    public static int sumDiagonal(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (i = 0; i < arr.length; i++) {
                sum += arr[i][i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr;
        System.out.println("Enter the row: ");
        int row = sc.nextInt();
        System.out.println("Enter the column: ");
        int col = sc.nextInt();
        arr = new int[row][col];
        for (row = 0; row < arr.length; row++) {
            for (col = 0; col < arr[row].length; col++) {
                System.out.println("Enter an element at [" + row + "][" + col + "] is: ");
                arr[row][col] = sc.nextInt();
            }
        }
        System.out.println("Sum of main diagonal is: "+sumDiagonal(arr));
    }
}
