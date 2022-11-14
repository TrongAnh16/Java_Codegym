import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = sc.nextDouble();
        System.out.print("Enter b: ");
        double b = sc.nextDouble();
        System.out.print("Enter c: ");
        double c = sc.nextDouble();
        quadraticEquation quadraticEquation = new quadraticEquation(a, b, c);
        System.out.println("Your quadraticEquation: \n" + quadraticEquation.display());
        System.out.println("Delta = "+quadraticEquation.getDiscriminant());
        if (quadraticEquation.getA() == 0 || quadraticEquation.getA() == 0 && quadraticEquation.getB() == 0) {
            System.out.println("Not a quadratic equation");
        }
        else if (quadraticEquation.getDiscriminant() >  0 ){
            System.out.println("The equation has two roots: " + quadraticEquation.getRoot1() +" and "+ quadraticEquation.getRoot2());
        }else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println("The equation has one roots: "+ quadraticEquation.getRoot1());
        }else {
            System.out.println("The equation has no real roots");
        }
    }
}
