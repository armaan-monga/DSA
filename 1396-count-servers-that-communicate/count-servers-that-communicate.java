class Solution {

    int m, n;

    public int countServers(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        int ans = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int i = 0; i < m; i++) {

            for(int j = 0; j < n; j++) {

                if(grid[i][j] == 1 && !vis[i][j]) {

                    Queue<int[]> q = new LinkedList<>();

                    q.offer(new int[]{i, j});
                    vis[i][j] = true;

                    int count = 0;

                    while(!q.isEmpty()) {

                        int[] curr = q.poll();

                        int row = curr[0];
                        int col = curr[1];

                        count++;

                        // Explore entire row and column
                        for(int k = 0; k < n; k++) {

                            if(grid[row][k] == 1 && !vis[row][k]) {

                                vis[row][k] = true;
                                q.offer(new int[]{row, k});
                            }
                        }

                        for(int k = 0; k < m; k++) {

                            if(grid[k][col] == 1 && !vis[k][col]) {

                                vis[k][col] = true;
                                q.offer(new int[]{k, col});
                            }
                        }
                    }

                    if(count > 1) {
                        ans += count;
                    }
                }
            }
        }

        return ans;
    }
}