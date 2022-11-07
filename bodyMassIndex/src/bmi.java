import java.util.Scanner;

public class bmi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float weight, height, bmi;
        System.out.println("Enter your weight(kg): ");
        weight = sc.nextFloat();
        System.out.println("Enter your height(m): ");
        height = sc.nextFloat();
        bmi = weight / (height * height);
        if (bmi < 18.5) {
            System.out.println("You are underweight");
        } else if (bmi < 25.0) {
            System.out.println("You are normal");
                } else if (bmi < 30) {
                        System.out.println("You are overweight");
                        }else {
                                System.out.println("You are obese");
                                }
    }
}
