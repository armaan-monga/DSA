import java.util.Stack;

class Solution {

    public int calculate(String s) {

        Stack<Integer> num = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // skip spaces
            if (ch == ' ') continue;

            // parse full number (multi-digit)
            if (Character.isDigit(ch)) {
                int val = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--; // adjust index
                num.push(val);
            }
            // operator
            else {
                while (!op.isEmpty() && precedence(op.peek()) >= precedence(ch)) {
                    int v2 = num.pop();
                    int v1 = num.pop();
                    char oper = op.pop();

                    if (oper == '+') num.push(v1 + v2);
                    else if (oper == '-') num.push(v1 - v2);
                    else if (oper == '*') num.push(v1 * v2);
                    else if (oper == '/') num.push(v1 / v2);
                }
                op.push(ch);
            }
        }

        // final evaluation
        while (!op.isEmpty()) {
            int v2 = num.pop();
            int v1 = num.pop();
            char oper = op.pop();

            if (oper == '+') num.push(v1 + v2);
            else if (oper == '-') num.push(v1 - v2);
            else if (oper == '*') num.push(v1 * v2);
            else if (oper == '/') num.push(v1 / v2);
        }

        return num.peek();
    }

    // operator precedence
    static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        return 0;
    }
}
