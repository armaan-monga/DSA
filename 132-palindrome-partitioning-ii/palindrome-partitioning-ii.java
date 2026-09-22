class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int index = n - 1; index >= 0; index--) {
            int min = Integer.MAX_VALUE;
            for (int i = index; i < n; i++) {
                if (isPalindrome(s, index, i)) {
                    int partition = 1 + dp[i + 1];
                    min = Math.min(min, partition);
                }
            }
            dp[index] = min;
        }
        return dp[0] - 1;
    }
    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}