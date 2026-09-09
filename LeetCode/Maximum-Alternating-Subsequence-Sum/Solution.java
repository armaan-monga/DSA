1class Solution {
2    public long maxAlternatingSum(int[] nums) {
3        int n = nums.length;
4        long[][] dp = new long[n + 1][2];
5        for (int i = n - 1; i >= 0; i--) {
6            dp[i][1] = Math.max(
7                nums[i] + dp[i + 1][0],
8                dp[i + 1][1]
9            );
10            dp[i][0] = Math.max(
11                -nums[i] + dp[i + 1][1],
12                dp[i + 1][0]
13            );
14        }
15        return dp[0][1];
16    }
17}