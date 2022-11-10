import java.util.Scanner;

public class studentPass {
    public static int studentPassExam(double[] student) {
        int pass = 0;
        for (int i = 0; i < student.length; i++) {
            if (student[i] >= 5 && student[i] <= 10) {
                pass += 1;
            }
        }
        return pass;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;

        do {
            System.out.println("Enter a number of students: ");
            size = sc.nextInt();
            if (size > 30) {
                System.out.println("Number of students are exceed 30.");
            }
        } while (size > 30);

        double[] student = new double[size];
        int j = 0;
        while (j < student.length) {
            System.out.println("Enter a mark of student " + (j + 1) + ": ");
            student[j] = sc.nextDouble();
            j++;
        }
        System.out.println(studentPassExam(student));
    }
}
