import java.util.Scanner;

public class findElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] students = {"Paul", "Cris", "John"};
        System.out.println("Enter an element want to find: ");
        String element = sc.nextLine();
        for (int i = 0; i < students.length; i++) {
            if (element.equals(students[i])) {
                System.out.println(students[i] +" at index: " +i);
                break;
            }else if (i == students.length - 1){
                System.out.println("Element does not exist in array");
            }
        }
    }
}
