import java.util.*;

public class PreviousSmallerElement {
    public static void previousSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty())
                System.out.print(-1 + " ");
            else
                System.out.print(stack.peek() + " ");

            stack.push(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        previousSmaller(arr);
    }
}