1class Solution {
2    public boolean checkPartitioning(String s) {
3        int n = s.length();
4        boolean[][] palindrome = new boolean[n][n];
5        for (int i = n - 1; i >= 0; i--) {
6            for (int j = i; j < n; j++) {
7                if (s.charAt(i) == s.charAt(j) &&
8                    (j - i <= 2 || palindrome[i + 1][j - 1])) {
9                    palindrome[i][j] = true;
10                }
11            }
12        }
13        boolean[][] dp = new boolean[n + 1][4];
14        dp[n][3] = true;
15        for (int index = n - 1; index >= 0; index--) {
16            for (int parts = 2; parts >= 0; parts--) {
17                for (int end = index; end < n; end++) {
18                    if (palindrome[index][end]) {
19                        if (dp[end + 1][parts + 1]) {
20                            dp[index][parts] = true;
21                            break;
22                        }
23                    }
24                }
25            }
26        }
27        return dp[0][0];
28    }
29}