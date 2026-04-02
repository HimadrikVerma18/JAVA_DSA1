import java.util.*;

class Node {
    int data;
    Node next;
    Node(int d) { data = d; next = null; }
}

public class ReverseLinkedListUsingStack {

    static Node reverse(Node head) {
        Stack<Node> stack = new Stack<>();
        Node temp = head;

        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        head = stack.pop();
        temp = head;

        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }

        temp.next = null;
        return head;
    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        head = reverse(head);
        print(head);
    }
}