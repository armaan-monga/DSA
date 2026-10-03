class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            }
            else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                else {
                    sb.setCharAt(i, '#');
                }
            }
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            sb.setCharAt(index, '#');
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '#') {
                result.append(sb.charAt(i));
            }
        }
        return result.toString();
    }
}