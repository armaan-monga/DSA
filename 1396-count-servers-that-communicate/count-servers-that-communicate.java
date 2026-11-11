class Solution {

    public int countServers(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int count = 0;

        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < n; i++) {

            for(int j = 0; j < m; j++) {

                if(!vis[i][j] && grid[i][j] == 1) {

                    int c = bfs(i, j, vis, grid);

                    if(c > 1) {
                        count += c;
                    }
                }
            }
        }

        return count;
    }

    public int bfs(int i, int j, boolean[][] vis, int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{i, j});
        vis[i][j] = true;

        int count = 0;

        while(!q.isEmpty()) {

            int[] top = q.poll();

            int row = top[0];
            int col = top[1];

            count++;

            // Explore entire row
            for(int k = 0; k < m; k++) {

                if(grid[row][k] == 1 && !vis[row][k]) {

                    vis[row][k] = true;
                    q.add(new int[]{row, k});
                }
            }

            // Explore entire column
            for(int k = 0; k < n; k++) {

                if(grid[k][col] == 1 && !vis[k][col]) {

                    vis[k][col] = true;
                    q.add(new int[]{k, col});
                }
            }
        }

        return count;
    }
}