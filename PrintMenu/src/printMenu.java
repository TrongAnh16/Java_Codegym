import java.util.Scanner;

public class printMenu {
    public static void main(String[] args) {
        int choice = -1;
        Scanner sc = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle (The corner is square at 4 different angles: top-left, top-right, bottom-left, bottom-right)");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 1; i < 5; i++) {
                        for (int j = 1; j < 9; j++) {
                            System.out.print(" * ");
                        }
                        System.out.println("");
                    }
                    break;
                case 2:
                    System.out.println("Enter your choice Triangle: ");
                    int choiceTri = sc.nextInt();
                    switch (choiceTri) {
                        case 1:
                            for (int i = 1; i <= 8; i++) {
                                for (int j = 1; j < i; j++) {
                                    System.out.print("*");
                                }
                                System.out.println("");
                            }
                            break;
                        case 2:
                            for (int i = 1; i <= 8; i++) {
                                for (int j = 8 - i; j > 0; j--) {
                                    System.out.print("*");
                                }
                                System.out.println("");
                            }
                            break;
                        case 3:
                            for (int i = 1; i <= 8; i++) {
                                for (int j = 1; j <= 8; j++) {
                                    if (j > 8 - i) {
                                        System.out.print("*");
                                    } else {
                                        System.out.print(" ");
                                    }

                                }
                                System.out.println("");
                            }
                            break;
                        case 4:
                            for (int i = 1; i <= 8; i++) {
                                for (int j = 1; j <= 8; j++) {
                                    if (j >= i) {
                                        System.out.print("*");
                                    } else {
                                        System.out.print(" ");
                                    }
                                }
                                System.out.println("");
                            }
                            break;
                    }
                    break;
                case 3:
                    for (int i = 1; i <= 7; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print(" * ");
                        }
                        System.out.println("");
                    }
                    break;
            }
        }
    }
}
