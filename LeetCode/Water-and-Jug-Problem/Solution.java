1class Solution {
2    public boolean canMeasureWater(int x, int y, int target) {
3        if (target > x + y) {
4            return false;
5        }
6        Queue<int[]> queue = new LinkedList<>();
7        boolean[][] visited = new boolean[x + 1][y + 1];
8        queue.offer(new int[]{0, 0});
9        visited[0][0] = true;
10        while (!queue.isEmpty()) {
11            int[] curr = queue.poll();
12            int a = curr[0];
13            int b = curr[1];
14            if (a + b == target) {
15                return true;
16            }
17            int[][] nextStates = {
18                {x, b},
19                {a, y},
20                {0, b},
21                {a, 0}
22            };
23            int pour = Math.min(a, y - b);
24            nextStates = addState(nextStates, a - pour, b + pour);
25            pour = Math.min(b, x - a);
26            nextStates = addState(nextStates, a + pour, b - pour);
27            for (int[] next : nextStates) {
28                int na = next[0];
29                int nb = next[1];
30                if (!visited[na][nb]) {
31                    visited[na][nb] = true;
32                    queue.offer(new int[]{na, nb});
33                }
34            }
35        }
36        return false;
37    }
38    private int[][] addState(int[][] states, int a, int b) {
39        int[][] result = Arrays.copyOf(states, states.length + 1);
40        result[states.length] = new int[]{a, b};
41        return result;
42    }
43}