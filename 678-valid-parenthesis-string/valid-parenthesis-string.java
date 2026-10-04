class Solution {
    Boolean[][] dp;
    public boolean solve(int i, String s, int open) {
        if (open < 0) {
            return false;
        }
        if (i == s.length()) {
            return open == 0;
        }
        if (dp[i][open] != null) {
            return dp[i][open];
        }
        char ch = s.charAt(i);
        boolean ans = false;
        if (ch == '(') {
            ans = solve(i + 1, s, open + 1);
        } 
        else if (ch == ')') {
            if (open > 0) {
                ans = solve(i + 1, s, open - 1);
            }

        } 
        else { 
            if (solve(i + 1, s, open + 1)) {
                ans = true;
            }
            else if (solve(i + 1, s, open)) {
                ans = true;
            }
            else if (open > 0 && solve(i + 1, s, open - 1)) {
                ans = true;
            }
        }
        dp[i][open] = ans;
        return ans;
    }

    public boolean checkValidString(String s) {
        int n = s.length();
        dp = new Boolean[n][n + 1];
        return solve(0, s, 0);
    }
}