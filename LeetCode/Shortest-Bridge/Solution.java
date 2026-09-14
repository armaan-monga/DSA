1class Solution {
2    int n;
3    int[][] dir = {
4        {1, 0},
5        {-1, 0},
6        {0, 1},
7        {0, -1}
8    };
9    public int shortestBridge(int[][] grid) {
10        n = grid.length;
11        Queue<int[]> q = new LinkedList<>();
12        boolean found = false;
13        for (int i = 0; i < n && !found; i++) {
14            for (int j = 0; j < n && !found; j++) {
15                if (grid[i][j] == 1) {
16                    q.offer(new int[]{i, j});
17                    grid[i][j] = 2;
18                    while (!q.isEmpty()) {
19                        int[] curr = q.poll();
20                        int r = curr[0];
21                        int c = curr[1];
22                        for (int[] d : dir) {
23                            int nr = r + d[0];
24                            int nc = c + d[1];
25                            if (nr >= 0 && nr < n &&
26                                nc >= 0 && nc < n &&
27                                grid[nr][nc] == 1) {
28                                grid[nr][nc] = 2;
29                                q.offer(new int[]{nr, nc});
30                            }
31                        }
32                    }
33                    found = true;
34                }
35            }
36        }
37        for (int i = 0; i < n; i++) {
38            for (int j = 0; j < n; j++) {
39                if (grid[i][j] == 2) {
40                    q.offer(new int[]{i, j});
41                }
42            }
43        }
44
45        int distance = 0;
46
47        while (!q.isEmpty()) {
48            int size = q.size();
49            for (int i = 0; i < size; i++) {
50                int[] curr = q.poll();
51                int r = curr[0];
52                int c = curr[1];
53                for (int[] d : dir) {
54                    int nr = r + d[0];
55                    int nc = c + d[1];
56                    if (nr >= 0 && nr < n &&
57                        nc >= 0 && nc < n) {
58                        if (grid[nr][nc] == 1) {
59                            return distance;
60                        }
61                        if (grid[nr][nc] == 0) {
62                            grid[nr][nc] = 2;
63                            q.offer(new int[]{nr, nc});
64                        }
65                    }
66                }
67            }
68            distance++;
69        }
70        return -1;
71    }
72}