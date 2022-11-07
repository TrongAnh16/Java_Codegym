import java.util.Scanner;

public class RectArea {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter a width: ");
        width = sc.nextFloat();
        System.out.println("Enter a height: ");
        height = sc.nextFloat();
        float area = width * height;
        System.out.println("Area is: "+ area);
    }
}