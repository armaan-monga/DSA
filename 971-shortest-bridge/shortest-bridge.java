class Solution {
    int n;
    int[][] dir = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    public int shortestBridge(int[][] grid) {
        n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        boolean found = false;
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n && !found; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    grid[i][j] = 2;
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        int r = curr[0];
                        int c = curr[1];
                        for (int[] d : dir) {
                            int nr = r + d[0];
                            int nc = c + d[1];
                            if (nr >= 0 && nr < n &&
                                nc >= 0 && nc < n &&
                                grid[nr][nc] == 1) {
                                grid[nr][nc] = 2;
                                q.offer(new int[]{nr, nc});
                            }
                        }
                    }
                    found = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int distance = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < n) {
                        if (grid[nr][nc] == 1) {
                            return distance;
                        }
                        if (grid[nr][nc] == 0) {
                            grid[nr][nc] = 2;
                            q.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
            distance++;
        }
        return -1;
    }
}