1class Solution {
2    public int maxStarSum(int[] vals, int[][] edges, int k) {
3        int n = vals.length;
4        List<List<Integer>> adj = new ArrayList<>();
5        for (int i = 0; i < n; i++) {
6            adj.add(new ArrayList<>());
7        }
8        for (int[] edge : edges) {
9            int u = edge[0];
10            int v = edge[1];
11            adj.get(u).add(v);
12            adj.get(v).add(u);
13        }
14        int ans = Integer.MIN_VALUE;
15        for (int i = 0; i < n; i++) {
16            List<Integer> neighbors = new ArrayList<>();
17            for (int neighbor : adj.get(i)) {
18                if (vals[neighbor] > 0) {
19                    neighbors.add(vals[neighbor]);
20                }
21            }
22            Collections.sort(neighbors, Collections.reverseOrder());
23            int sum = vals[i];
24            for (int j = 0; j < Math.min(k, neighbors.size()); j++) {
25                sum += neighbors.get(j);
26            }
27            ans = Math.max(ans, sum);
28        }
29        return ans;
30    }
31}