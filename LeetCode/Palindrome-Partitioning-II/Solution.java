1class Solution {
2    public int minCut(String s) {
3        int n = s.length();
4        int[] dp = new int[n + 1];
5        dp[n] = 0;
6        for (int index = n - 1; index >= 0; index--) {
7            int min = Integer.MAX_VALUE;
8            for (int i = index; i < n; i++) {
9                if (isPalindrome(s, index, i)) {
10                    int partition = 1 + dp[i + 1];
11                    min = Math.min(min, partition);
12                }
13            }
14            dp[index] = min;
15        }
16        return dp[0] - 1;
17    }
18    public boolean isPalindrome(String s, int left, int right) {
19        while (left < right) {
20            if (s.charAt(left++) != s.charAt(right--)) {
21                return false;
22            }
23        }
24        return true;
25    }
26}