// class Solution {
//     Boolean[][] dp;
//     public boolean solve(int i, String s, int open) {
//         if (open < 0) {
//             return false;
//         }
//         if (i == s.length()) {
//             return open == 0;
//         }
//         if (dp[i][open] != null) {
//             return dp[i][open];
//         }
//         char ch = s.charAt(i);
//         boolean ans = false;
//         if (ch == '(') {
//             ans = solve(i + 1, s, open + 1);
//         } 
//         else if (ch == ')') {
//             if (open > 0) {
//                 ans = solve(i + 1, s, open - 1);
//             }

//         } 
//         else { 
//             if (solve(i + 1, s, open + 1)) {
//                 ans = true;
//             }
//             else if (solve(i + 1, s, open)) {
//                 ans = true;
//             }
//             else if (open > 0 && solve(i + 1, s, open - 1)) {
//                 ans = true;
//             }
//         }
//         dp[i][open] = ans;
//         return ans;
//     }

//     public boolean checkValidString(String s) {
//         int n = s.length();
//         dp = new Boolean[n][n + 1];
//         return solve(0, s, 0);
//     }
// }


class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        dp[n][0] = true;
        for (int i = n - 1; i >= 0; i--) {
            for (int open = 0; open <= n; open++) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    if (open + 1 <= n) {
                        dp[i][open] = dp[i + 1][open + 1];
                    }
                } 
                else if (ch == ')') {
                    if (open > 0) {
                        dp[i][open] = dp[i + 1][open - 1];
                    }

                } 
                else { 
                    boolean asOpen = false;
                    if (open + 1 <= n) {
                        asOpen = dp[i + 1][open + 1];
                    }
                    boolean asEmpty = dp[i + 1][open];
                    boolean asClose = false;
                    if (open > 0) {
                        asClose = dp[i + 1][open - 1];
                    }
                    dp[i][open] = asOpen || asEmpty || asClose;
                }
            }
        }
        return dp[0][0];
    }
}