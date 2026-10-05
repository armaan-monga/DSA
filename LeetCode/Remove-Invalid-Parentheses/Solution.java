1class Solution {
2    int minRemove = Integer.MAX_VALUE;
3    Set<String> set = new HashSet<>();
4    public boolean check(StringBuilder s) {
5        int open = 0;
6        for (int i = 0; i < s.length(); i++) {
7            char ch = s.charAt(i);
8            if (ch == '(') {
9                open++;
10            } 
11            else if (ch == ')') {
12                open--;
13                if (open < 0) {
14                    return false;
15                }
16            }
17        }
18        return open == 0;
19    }
20
21    public List<String> removeInvalidParentheses(String s) {
22        StringBuilder sb = new StringBuilder(s);
23        solve(0, sb, 0);
24        return new ArrayList<>(set);
25    }
26
27    public void solve(int i, StringBuilder sb, int removed) {
28        if (removed > minRemove) {
29            return;
30        }
31        if (i == sb.length()) {
32            if (check(sb)) {
33                if (removed < minRemove) {
34                    minRemove = removed;
35                    set.clear();
36                }
37                if (removed == minRemove) {
38                    set.add(sb.toString());
39                }
40            }
41            return;
42        }
43        char ch = sb.charAt(i);
44        if (ch == '(' || ch == ')') {
45            sb.deleteCharAt(i);
46            solve(i, sb, removed + 1);
47            sb.insert(i, ch);
48        }
49        solve(i + 1, sb, removed);
50    }
51}