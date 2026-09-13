1class Solution {
2    public int largestOverlap(int[][] img1, int[][] img2) {
3        int n = img1.length;
4        int ans = 0;
5        for (int rowShift = -(n - 1); rowShift <= n - 1; rowShift++) {
6            for (int colShift = -(n - 1); colShift <= n - 1; colShift++) {
7                int count = 0;
8                for (int i = 0; i < n; i++) {
9                    for (int j = 0; j < n; j++) {
10                        int x = i + rowShift;
11                        int y = j + colShift;
12                        if (x >= 0 && x < n && y >= 0 && y < n) {
13                            if (img1[i][j] == 1 && img2[x][y] == 1) {
14                                count++;
15                            }
16                        }
17                    }
18                }
19                ans = Math.max(ans, count);
20            }
21        }
22        return ans;
23    }
24}