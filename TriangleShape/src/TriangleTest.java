import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a side 1: ");
        double side1 = sc.nextDouble();
        System.out.println("Enter a side 2: ");
        double side2 = sc.nextDouble();
        System.out.println("Enter a side 3: ");
        double side3 = sc.nextDouble();
        System.out.println("Enter a color: ");
        String color = sc.next();

        Triangle triangle1 = new Triangle(side1,side2,side3,color);
        System.out.println(triangle1);
    }
}
