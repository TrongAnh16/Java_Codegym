import java.util.Scanner;

public class cToFFToC {
    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (celsius*9)/5 + 32;
        return fahrenheit;
    }

    public static double fahrenheitToCelsius(double fahrenheit){
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        return celsius;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Fahrenheit to Celsius: ");
        System.out.println("2. Celsius to Fahrenheit: ");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter a celsius: ");
                double celsius = sc.nextDouble();
                System.out.println(celsius+" celsius to fahrenheit is: " +celsiusToFahrenheit(celsius));
                break;
            case 2:
                System.out.println("Enter a fahrenheit: ");
                double fahrenheit = sc.nextDouble();
                System.out.println(fahrenheit+ " fahrenheit to celsius is: " +fahrenheitToCelsius(fahrenheit));
                break;
            case 0:
                System.out.println("Exit");
                break;
        }
    }
}
