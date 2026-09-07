class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if (target > x + y) {
            return false;
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[x + 1][y + 1];
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int a = curr[0];
            int b = curr[1];
            if (a + b == target) {
                return true;
            }
            int[][] nextStates = {
                {x, b},
                {a, y},
                {0, b},
                {a, 0}
            };
            int pour = Math.min(a, y - b);
            nextStates = addState(nextStates, a - pour, b + pour);
            pour = Math.min(b, x - a);
            nextStates = addState(nextStates, a + pour, b - pour);
            for (int[] next : nextStates) {
                int na = next[0];
                int nb = next[1];
                if (!visited[na][nb]) {
                    visited[na][nb] = true;
                    queue.offer(new int[]{na, nb});
                }
            }
        }
        return false;
    }
    private int[][] addState(int[][] states, int a, int b) {
        int[][] result = Arrays.copyOf(states, states.length + 1);
        result[states.length] = new int[]{a, b};
        return result;
    }
}