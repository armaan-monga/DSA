class Solution {
    int m, n;
    int MOD = 1_000_000_007;
    int[][] grid;
    int[][] dp;

    public int solve(int i, int j) {
        // Destination reached
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        int right = move(i, j + 1, 0);
        int down = move(i + 1, j, 1);

        return dp[i][j]=(int) (((long) right + down) % MOD);
    }

    // dir = 0 means moving right
    // dir = 1 means moving down
    public int move(int i, int j, int dir) {
        // Out of bounds
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }

        // Keep reflecting while we encounter mirrors
        while (grid[i][j] == 1) {
            if (dir == 0) {
                // Moving right into a mirror -> move below it
                i++;
                dir = 1;
            } else {
                // Moving down into a mirror -> move right of it
                j++;
                dir = 0;
            }

            // Reflection went outside the grid
            if (i >= m || j >= n) {
                return 0;
            }
        }

        // We reached an empty cell
        return solve(i, j);
    }
    public int uniquePaths(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        dp=new int[m][n];
        for(int[] v:dp){
            Arrays.fill(v,-1);
        }
        return solve(0, 0);
    }
}