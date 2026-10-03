1class Solution {
2    public int minInsertions(String s) {
3        int open = 0;
4        int ans = 0;
5        for (int i = 0; i < s.length(); i++) {
6            if (s.charAt(i) == '(') {
7                open++;
8            } else {
9                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
10                    i++;
11                } else {
12                    ans++;
13                }
14                if (open > 0) {
15                    open--;
16                } else {
17                    ans++;
18                }
19            }
20        }
21        ans += 2 * open;
22        return ans;
23    }
24}