import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class interestBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a money: ");
        int money = sc.nextInt();
        System.out.println("Enter an interest(%/year): ");
        double interest = sc.nextDouble();
        System.out.println("Enter a month: ");
        int month = sc.nextInt();

        double totalInterest = 0;
        for (int i = 0; i < month; i++)
            totalInterest = money * Math.pow((1 + (interest / 100) / 12), month);
        NumberFormat vnd = new DecimalFormat("#,###");
        String m = vnd.format(totalInterest);
        System.out.println("Your money you have after " + month + " month is: " + m + " VND");
    }
}
