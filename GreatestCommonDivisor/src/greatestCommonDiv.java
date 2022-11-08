import java.util.Scanner;

public class greatestCommonDiv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a first number: ");
        int a = Math.abs(sc.nextInt());
        System.out.println("Enter a second number: ");
        int b = Math.abs(sc.nextInt());
        if (a == 0 && b == 0) {
            System.out.println("Not exist a greatest common divisor");
            return;
        }
        if (a == 0) {
            System.out.println(b + " is a greatest common divisor");
            return;
        }
        if (b == 0) {
            System.out.println(a + " is a greatest common divisor");
            return;
        }
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        System.out.println(a + " is a greatest common divisor");
    }
}
