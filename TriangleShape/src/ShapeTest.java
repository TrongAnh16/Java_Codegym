import java.util.Scanner;

public class ShapeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a color: ");
        String color = sc.nextLine();
        Shape shape = new Shape(color);
        System.out.println(shape);
    }
}
