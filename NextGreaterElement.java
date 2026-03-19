import java.util.*;

public class NextGreaterElement {
    public static void nextGreater(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        nextGreater(arr);
    }
}