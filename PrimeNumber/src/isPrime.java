import java.util.Scanner;

public class isPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            System.out.println("Enter a number: ");
            int a = sc.nextInt();
            if (a < 2) {
                System.out.println(a + " is not a prime number");
                return;
            }
            if (a == 2) {
                System.out.println(a + " is a prime number");
                return;
            }
            for (int i = 2; i < a; i++) {
                if (a % i == 0) {
                    System.out.println(a + " is not a prime number");
                    break;
                } else if (i == a - 1) {
                    System.out.println(a + " is a prime number");
                }
            }
        }

}
