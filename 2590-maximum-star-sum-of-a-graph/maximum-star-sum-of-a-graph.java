class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            List<Integer> neighbors = new ArrayList<>();
            for (int neighbor : adj.get(i)) {
                if (vals[neighbor] > 0) {
                    neighbors.add(vals[neighbor]);
                }
            }
            Collections.sort(neighbors, Collections.reverseOrder());
            int sum = vals[i];
            for (int j = 0; j < Math.min(k, neighbors.size()); j++) {
                sum += neighbors.get(j);
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}