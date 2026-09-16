1class Solution {
2    public int checkWays(int[][] pairs) {
3        boolean[][] graph = new boolean[501][501];
4        int[] degree = new int[501];
5        for (int[] pair : pairs) {
6            int x = pair[0];
7            int y = pair[1];
8            graph[x][y] = true;
9            graph[y][x] = true;
10            degree[x]++;
11            degree[y]++;
12        }
13        int n = 0;
14        for (int i = 1; i <= 500; i++) {
15            if (degree[i] > 0) {
16                n++;
17            }
18        }
19        int root = -1;
20        for (int i = 1; i <= 500; i++) {
21            if (degree[i] == n - 1) {
22                root = i;
23                break;
24            }
25        }
26        if (root == -1) {
27            return 0;
28        }
29        int ways = 1;
30        for (int node = 1; node <= 500; node++) {
31            if (degree[node] == 0 || node == root) {
32                continue;
33            }
34            int parent = -1;
35            for (int neighbor = 1; neighbor <= 500; neighbor++) {
36                if (graph[node][neighbor] &&
37                    degree[neighbor] >= degree[node]) {
38                    if (parent == -1 ||
39                        degree[neighbor] < degree[parent]) {
40                        parent = neighbor;
41                    }
42                }
43            }
44            if (parent == -1) {
45                return 0;
46            }
47            for (int neighbor = 1; neighbor <= 500; neighbor++) {
48                if (neighbor == parent || !graph[node][neighbor]) {
49                    continue;
50                }
51                if (!graph[parent][neighbor]) {
52                    return 0;
53                }
54            }
55            if (degree[parent] == degree[node]) {
56                ways = 2;
57            }
58        }
59        return ways;
60    }
61}