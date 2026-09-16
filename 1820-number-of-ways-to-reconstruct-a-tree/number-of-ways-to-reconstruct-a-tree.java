class Solution {
    public int checkWays(int[][] pairs) {
        boolean[][] graph = new boolean[501][501];
        int[] degree = new int[501];
        for (int[] pair : pairs) {
            int x = pair[0];
            int y = pair[1];
            graph[x][y] = true;
            graph[y][x] = true;
            degree[x]++;
            degree[y]++;
        }
        int n = 0;
        for (int i = 1; i <= 500; i++) {
            if (degree[i] > 0) {
                n++;
            }
        }
        int root = -1;
        for (int i = 1; i <= 500; i++) {
            if (degree[i] == n - 1) {
                root = i;
                break;
            }
        }
        if (root == -1) {
            return 0;
        }
        int ways = 1;
        for (int node = 1; node <= 500; node++) {
            if (degree[node] == 0 || node == root) {
                continue;
            }
            int parent = -1;
            for (int neighbor = 1; neighbor <= 500; neighbor++) {
                if (graph[node][neighbor] &&
                    degree[neighbor] >= degree[node]) {
                    if (parent == -1 ||
                        degree[neighbor] < degree[parent]) {
                        parent = neighbor;
                    }
                }
            }
            if (parent == -1) {
                return 0;
            }
            for (int neighbor = 1; neighbor <= 500; neighbor++) {
                if (neighbor == parent || !graph[node][neighbor]) {
                    continue;
                }
                if (!graph[parent][neighbor]) {
                    return 0;
                }
            }
            if (degree[parent] == degree[node]) {
                ways = 2;
            }
        }
        return ways;
    }
}