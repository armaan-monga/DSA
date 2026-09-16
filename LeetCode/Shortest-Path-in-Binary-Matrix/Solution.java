1class Solution {
2    public int shortestPathBinaryMatrix(int[][] grid) {
3        int n = grid.length;
4        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
5            return -1;
6        }
7        Queue<int[]> q = new LinkedList<>();
8        q.offer(new int[]{0, 0, 1});
9        grid[0][0] = 1; 
10        int[][] directions = {
11            {-1, -1}, {-1, 0}, {-1, 1},
12            {0, -1},           {0, 1},
13            {1, -1},  {1, 0},  {1, 1}
14        };
15        while (!q.isEmpty()) {
16            int[] current = q.poll();
17            int r = current[0];
18            int c = current[1];
19            int distance = current[2];
20            if (r == n - 1 && c == n - 1) {
21                return distance;
22            }
23            for (int[] dir : directions) {
24                int nr = r + dir[0];
25                int nc = c + dir[1];
26                if (nr >= 0 && nr < n &&
27                    nc >= 0 && nc < n &&
28                    grid[nr][nc] == 0) {
29                    grid[nr][nc] = 1;
30                    q.offer(new int[]{nr, nc, distance + 1});
31                }
32            }
33        }
34        return -1;
35    }
36}