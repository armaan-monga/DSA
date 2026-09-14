class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        if (x == y) {
            return 0;
        }
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.offer(x);
        visited.add(x);
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (curr == y) {
                    return steps;
                }
                if (curr % 11 == 0) {
                    int next = curr / 11;
                    if (!visited.contains(next)) {
                        visited.add(next);
                        q.offer(next);
                    }
                }
                if (curr % 5 == 0) {
                    int next = curr / 5;
                    if (!visited.contains(next)) {
                        visited.add(next);
                        q.offer(next);
                    }
                }
                int next = curr + 1;
                if (!visited.contains(next)) {
                    visited.add(next);
                    q.offer(next);
                }
                if (curr > 1) {
                    next = curr - 1;
                    if (!visited.contains(next)) {
                        visited.add(next);
                        q.offer(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}