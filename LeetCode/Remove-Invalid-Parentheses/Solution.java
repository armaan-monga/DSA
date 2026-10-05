1class Solution {
2
3    int minRemove = Integer.MAX_VALUE;
4    Set<String> set = new HashSet<>();
5    Set<String> visited = new HashSet<>();
6
7    public boolean check(StringBuilder s) {
8
9        int open = 0;
10
11        for (int i = 0; i < s.length(); i++) {
12
13            char ch = s.charAt(i);
14
15            if (ch == '(') {
16                open++;
17            } 
18            else if (ch == ')') {
19
20                open--;
21
22                if (open < 0) {
23                    return false;
24                }
25            }
26        }
27
28        return open == 0;
29    }
30
31    public List<String> removeInvalidParentheses(String s) {
32
33        StringBuilder sb = new StringBuilder(s);
34
35        solve(0, sb, 0);
36
37        return new ArrayList<>(set);
38    }
39
40    public void solve(int i, StringBuilder sb, int removed) {
41
42        if (removed > minRemove) {
43            return;
44        }
45
46        String state = sb.toString() + "#" + i + "#" + removed;
47
48        if (visited.contains(state)) {
49            return;
50        }
51
52        visited.add(state);
53
54        if (i == sb.length()) {
55
56            if (check(sb)) {
57
58                if (removed < minRemove) {
59                    minRemove = removed;
60                    set.clear();
61                }
62
63                if (removed == minRemove) {
64                    set.add(sb.toString());
65                }
66            }
67
68            return;
69        }
70
71        char ch = sb.charAt(i);
72
73        // Remove
74        if (ch == '(' || ch == ')') {
75
76            sb.deleteCharAt(i);
77
78            solve(i, sb, removed + 1);
79
80            sb.insert(i, ch);
81        }
82
83        // Keep
84        solve(i + 1, sb, removed);
85    }
86}