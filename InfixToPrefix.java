import java.util.*;

public class InfixToPrefix {

    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    static String convert(String exp) {
        exp = reverse(exp);

        char[] chars = exp.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(')
                chars[i] = ')';
            else if (chars[i] == ')')
                chars[i] = '(';
        }

        String postfix = infixToPostfix(new String(chars));
        return reverse(postfix);
    }

    static String infixToPostfix(String exp) {
        String result = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c))
                result += c;

            else if (c == '(')
                stack.push(c);

            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();
                stack.pop();
            }

            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek()))
                    result += stack.pop();
                stack.push(c);
            }
        }

        while (!stack.isEmpty())
            result += stack.pop();

        return result;
    }

    public static void main(String[] args) {
        String exp = "A+B*(C-D)";
        System.out.println("Prefix: " + convert(exp));
    }
}
