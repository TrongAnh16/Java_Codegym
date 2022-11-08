import java.util.Scanner;

public class firstPrime {
    public static boolean checkPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of primes to find: ");
        int number = sc.nextInt();
        int count = 0;
        int n = 2;
        System.out.println(number + " of primes to find: ");
        while (count < number) {
            if (checkPrime(n)) {
                System.out.print(n + " ");
                count += 1;
            }
            n++;
        }
    }
}
