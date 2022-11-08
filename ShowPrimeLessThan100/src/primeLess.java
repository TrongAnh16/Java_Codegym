import java.util.Scanner;

public class primeLess {
    public static boolean checkPrime(int n) {
        if (n == 2) return true;
        if (n < 2) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the limit of primes: ");
        int limit = sc.nextInt();
        int n = 2;

        while (n < limit) {
            if (checkPrime(n)) {
                System.out.print(n+ " ");
            }
            n++;
        }

    }
}
