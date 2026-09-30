class Solution {
    int ans = 0;
    public int maximumGood(int[][] statements) {
        int n = statements.length;
        boolean[] good = new boolean[n];
        solve(0, statements, good);
        return ans;
    }
    public void solve(int i, int[][] statements, boolean[] good) {
        if (i == statements.length) {
            if (isValid(statements, good)) {
                int count = 0;
                for (boolean x : good) {
                    if (x) {
                        count++;
                    }
                }
                ans = Math.max(ans, count);
            }
            return;
        }
        good[i] = true;
        solve(i + 1, statements, good);
        good[i] = false;
        solve(i + 1, statements, good);
    }
    public boolean isValid(int[][] statements, boolean[] good) {
        int n = statements.length;
        for (int i = 0; i < n; i++) {
            if (!good[i]) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (statements[i][j] == 2) {
                    continue;
                }
                if (statements[i][j] == 0 && good[j]) {
                    return false;
                }
                if (statements[i][j] == 1 && !good[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}