1class Solution {
2    public int minCut(String s) {
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
13        int[] dp = new int[n + 1];
14        dp[n] = 0;
15        for (int i = n - 1; i >= 0; i--) {
16            int min = Integer.MAX_VALUE;
17            for (int j = i; j < n; j++) {
18                if (palindrome[i][j]) {
19                    min = Math.min(min, 1 + dp[j + 1]);
20                }
21            }
22            dp[i] = min;
23        }
24        return dp[0] - 1;
25    }
26}