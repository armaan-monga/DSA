1class Solution {
2    int ans = 0;
3    public int maximumGood(int[][] statements) {
4        int n = statements.length;
5        boolean[] good = new boolean[n];
6        solve(0, statements, good);
7        return ans;
8    }
9    public void solve(int i, int[][] statements, boolean[] good) {
10        if (i == statements.length) {
11            if (isValid(statements, good)) {
12                int count = 0;
13                for (boolean x : good) {
14                    if (x) {
15                        count++;
16                    }
17                }
18                ans = Math.max(ans, count);
19            }
20            return;
21        }
22        good[i] = true;
23        solve(i + 1, statements, good);
24        good[i] = false;
25        solve(i + 1, statements, good);
26    }
27    public boolean isValid(int[][] statements, boolean[] good) {
28        int n = statements.length;
29        for (int i = 0; i < n; i++) {
30            if (!good[i]) {
31                continue;
32            }
33            for (int j = 0; j < n; j++) {
34                if (statements[i][j] == 2) {
35                    continue;
36                }
37                if (statements[i][j] == 0 && good[j]) {
38                    return false;
39                }
40                if (statements[i][j] == 1 && !good[j]) {
41                    return false;
42                }
43            }
44        }
45        return true;
46    }
47}