import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        int choice = -1;
        Scanner sc = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Draw triangle");
            System.out.println("2. Draw rectangle");
            System.out.println("3. Draw square");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1. Draw triangle");
                    System.out.println("*****");
                    System.out.println("****");
                    System.out.println("***");
                    System.out.println("**");
                    System.out.println("*");
                    break;
                case 2:
                    System.out.println("2. Draw rectangle");
                    System.out.println("*****");
                    System.out.println("*****");
                    System.out.println("*****");
                    System.out.println("*****");
                    System.out.println("*****");
                    break;
                case 3:
                    System.out.println("3. Draw square");
                    System.out.println("*  *  *  *  *");
                    System.out.println("*  *  *  *  *");
                    System.out.println("*  *  *  *  *");
                    System.out.println("*  *  *  *  *");
                    System.out.println("*  *  *  *  *");
                    break;
                case 0:
                    System.out.println("0. Exit");
                    break;
                default:
                    System.out.println("No choice. Please choice again.");
            }
        }
    }
}
