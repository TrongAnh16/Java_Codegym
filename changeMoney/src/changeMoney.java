import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class changeMoney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (1 > 0) {
            System.out.println("Enter the dollars: ");
            int usd = sc.nextInt();
            if (usd < 0) {
                System.out.println("Wrong input");
            }else {
                    int vnd = 23000 * usd;
                    NumberFormat df = new DecimalFormat("#,###");
                    String str = df.format(vnd);
                    System.out.println(str + " VND");
            }
        }
    }
}
