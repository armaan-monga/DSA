1class Solution {
2    int minRemove = Integer.MAX_VALUE;
3    Set<String> set = new HashSet<>();
4    Set<String> visited = new HashSet<>();
5    
6    public boolean check(StringBuilder s) {
7        int open = 0;
8        for (int i = 0; i < s.length(); i++) {
9            char ch = s.charAt(i);
10            if (ch == '(') {
11                open++;
12            } 
13            else if (ch == ')') {
14                open--;
15                if (open < 0) {
16                    return false;
17                }
18            }
19        }
20        return open == 0;
21    }
22    public List<String> removeInvalidParentheses(String s) {
23        StringBuilder sb = new StringBuilder(s);
24        solve(0, sb, 0);
25        return new ArrayList<>(set);
26    }
27
28    public void solve(int i, StringBuilder sb, int removed) {
29        if (removed > minRemove) {
30            return;
31        }
32        String state = sb.toString() + "#" + i + "#" + removed;
33        if (visited.contains(state)) {
34            return;
35        }
36        visited.add(state);
37        if (i == sb.length()) {
38            if (check(sb)) {
39                if (removed < minRemove) {
40                    minRemove = removed;
41                    set.clear();
42                }
43                if (removed == minRemove) {
44                    set.add(sb.toString());
45                }
46            }
47            return;
48        }
49
50        char ch = sb.charAt(i);
51        if (ch == '(' || ch == ')') {
52            sb.deleteCharAt(i);
53            solve(i, sb, removed + 1);
54            sb.insert(i, ch);
55        }
56        solve(i + 1, sb, removed);
57    }
58}