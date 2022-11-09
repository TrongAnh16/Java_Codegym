import java.util.Scanner;

public class maxValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        int[] billionaire;

        do {
            System.out.println("Enter the size: ");
            size = sc.nextInt();
            if (size > 20)
                System.out.println("Size does not exceed 20");
        } while (size > 20);

        billionaire = new int[size];
        int i = 0;
        while (i < billionaire.length) {
            System.out.println("Enter element " + (i + 1) + ": ");
            billionaire[i] = sc.nextInt();
            i++;
        }

        int max = billionaire[0];
        int index = 0;
        for (int j = 0; j < billionaire.length; j++) {
            if (billionaire[j] > max) {
                max = billionaire[j];
                index = j;
            }
        }
        System.out.print("Max value is: " + max);
        System.out.println(" at index " + index + " in array");
    }
}
