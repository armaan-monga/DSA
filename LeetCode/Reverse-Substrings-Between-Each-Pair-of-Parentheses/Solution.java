1class Solution {
2    public String reverseParentheses(String s) {
3        Stack<StringBuilder> stack = new Stack<>();
4        StringBuilder curr = new StringBuilder();
5        for (char ch : s.toCharArray()) {
6            if (ch == '(') {
7                stack.push(curr);
8                curr = new StringBuilder();
9            }
10            else if (ch == ')') {
11                curr.reverse();
12                StringBuilder prev = stack.pop();
13                prev.append(curr);
14                curr = prev;
15            }
16            else {
17                curr.append(ch);
18            }
19        }
20        return curr.toString();
21    }
22}