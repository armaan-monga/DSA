class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        if (dead.contains("0000")) {
            return -1;
        }

        q.offer("0000");
        visited.add("0000");

        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int j = 0; j < size; j++) {
                String curr = q.poll();

                if (curr.equals(target)) {
                    return level;
                }

                for (int i = 0; i < 4; i++) {
                    char[] arr = curr.toCharArray();

                    arr[i] = (char)((arr[i] - '0' + 1) % 10 + '0');
                    String next = new String(arr);

                    if (!dead.contains(next) && !visited.contains(next)) {
                        visited.add(next);
                        q.offer(next);
                    }

                    arr[i] = (char)((arr[i] - '0' + 8) % 10 + '0');
                    next = new String(arr);

                    if (!dead.contains(next) && !visited.contains(next)) {
                        visited.add(next);
                        q.offer(next);
                    }
                }
            }

            level++;
        }

        return -1;
    }
}