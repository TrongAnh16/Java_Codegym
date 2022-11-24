import java.util.Arrays;
import java.util.Stack;

public class ReverseArr {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6};
        Stack<Integer> stack = new Stack<>();
        System.out.println("Before: "+Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        System.out.println("After reverse: "+Arrays.toString(arr));
    }
}


