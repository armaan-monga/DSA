class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][] palindrome = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                    (j - i <= 2 || palindrome[i + 1][j - 1])) {
                    palindrome[i][j] = true;
                }
            }
        }
        boolean[][] dp = new boolean[n + 1][4];
        dp[n][3] = true;
        for (int index = n - 1; index >= 0; index--) {
            for (int parts = 2; parts >= 0; parts--) {
                for (int end = index; end < n; end++) {
                    if (palindrome[index][end]) {
                        if (dp[end + 1][parts + 1]) {
                            dp[index][parts] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0];
    }
}