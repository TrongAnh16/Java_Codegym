import java.util.Stack;

public class decimalToBinary {
    public static void main(String[] args) {
        int number = 68;
        Stack<Integer> stack = new Stack<>();
        while (number > 0) {
            stack.push(number % 2);
            number = number / 2;
        }
        System.out.println(stack);
        String binary = "";
        while (!(stack.isEmpty())) {
            binary += stack.pop();
        }
        System.out.print("Decimal to binary is: "+binary);
    }
}
