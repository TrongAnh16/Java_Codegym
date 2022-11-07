import java.util.Scanner;

public class Linear {
    public static void main(String[] args) {
        float a, b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập a: ");
        a = sc.nextFloat();
        System.out.println("Nhập b: ");
        b = sc.nextFloat();
        float result = -b/a;
        if (a == 0 && b == 0) {
            System.out.println("PT có vô số nghiệm");
        } else if (a == 0 && b != 0) {
            System.out.println("PT vô nghiệm");
                }else {
                    System.out.println("PT có 1 nghiệm: " +result);
                    }
        }
    }

