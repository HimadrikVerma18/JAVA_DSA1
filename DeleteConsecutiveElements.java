import java.util.*;

public class DeleteConsecutiveElements {

    public static void removeConsecutive(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            if (!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        System.out.println(stack);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 4};
        removeConsecutive(arr);
    }
}