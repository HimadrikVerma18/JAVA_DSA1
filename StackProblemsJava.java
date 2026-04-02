import java.util.*;

// Node class for Linked List
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Stack using Linked List
class StackLL {
    Node top;

    // Push
    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    // Pop
    int pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        int val = top.data;
        top = top.next;
        return val;
    }

    // Peek
    int peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    boolean isEmpty() {
        return top == null;
    }

    // Print Stack
    void print() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class StackProblemsJava {

    // 1. Reverse Stack using Linked List
    static void reverseStack(StackLL stack) {
        Node prev = null;
        Node curr = stack.top;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        stack.top = prev;
    }

    // 2. Sort Stack using Linked List
    static void sortStack(StackLL stack) {
        Stack<Integer> temp = new Stack<>();

        while (!stack.isEmpty()) {
            int curr = stack.pop();

            while (!temp.isEmpty() && temp.peek() > curr) {
                stack.push(temp.pop());
            }
            temp.push(curr);
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    static void sortAndReverse(StackLL stack) {
        sortStack(stack);
        reverseStack(stack);
    }

    // 3. Postfix to Infix
    static String postfixToInfix(String postfix) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                stack.push(ch + "");
            } else {
                String op2 = stack.pop();
                String op1 = stack.pop();
                String exp = "(" + op1 + ch + op2 + ")";
                stack.push(exp);
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        StackLL stack = new StackLL();

        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.print("Original Stack: ");
        stack.print();

        reverseStack(stack);
        System.out.print("Reversed Stack: ");
        stack.print();

        sortAndReverse(stack);
        System.out.print("Sorted + Reversed Stack: ");
        stack.print();

        String postfix = "AB+CD+*";
        System.out.println("Postfix: " + postfix);
        System.out.println("Infix: " + postfixToInfix(postfix));
    }
}
