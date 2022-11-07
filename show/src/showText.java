import java.util.Scanner;

public class showText {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text;
        System.out.println("Enter your name: ");
        text = sc.nextLine();
        System.out.println("Hello: " + text);
    }
}
