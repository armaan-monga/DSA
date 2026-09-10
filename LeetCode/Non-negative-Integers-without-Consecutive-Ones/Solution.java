1class Solution {
2    public int findIntegers(int n) {
3        int[] dp = new int[32];
4
5        dp[0] = 1;
6        dp[1] = 2;
7
8        for (int i = 2; i < 32; i++) {
9            dp[i] = dp[i - 1] + dp[i - 2];
10        }
11
12        int ans = 0;
13        int prevBit = 0;
14
15        for (int i = 30; i >= 0; i--) {
16            if ((n & (1 << i)) != 0) {
17                ans += dp[i];
18
19                if (prevBit == 1) {
20                    return ans;
21                }
22
23                prevBit = 1;
24            } else {
25                prevBit = 0;
26            }
27        }
28
29        return ans + 1;
30    }
31}