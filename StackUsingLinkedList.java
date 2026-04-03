class StackUsingLinkedList {

    static class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }

    Node top;

    void push(int x) {
        Node temp = new Node(x);
        temp.next = top;
        top = temp;
    }

    int pop() {
        if (top == null) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int val = top.data;
        top = top.next;
        return val;
    }

    void display() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        StackUsingLinkedList s = new StackUsingLinkedList();
        s.push(10);
        s.push(20);
        s.push(30);
        s.display();
    }
}