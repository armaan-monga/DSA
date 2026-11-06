class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] q) {
        Arrays.sort(logs, (a,b) -> Integer.compare(a[1], b[1]));
        int[][] queries = new int[q.length][2];
        for(int i = 0; i < q.length; i++) {
            queries[i][0] = q[i];
            queries[i][1] = i;
        }
        Arrays.sort(queries, (a,b) -> Integer.compare(a[0], b[0]));
        int[] ans = new int[q.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int count = 0;
        for(int i = 0; i < q.length; i++) {
            int time = queries[i][0];
            int idx = queries[i][1];
            while(right < logs.length && logs[right][1] <= time) {
                int server = logs[right][0];
                map.put(server, map.getOrDefault(server,0)+1);
                if(map.get(server) == 1) {
                    count++;
                }
                right++;
            }
            while(left < right && logs[left][1] < time-x) {
                int server = logs[left][0];
                map.put(server, map.get(server)-1);
                if(map.get(server) == 0) {
                    map.remove(server);
                    count--;
                }
                left++;
            }
            ans[idx] = n-count;
        }
        return ans;
    }
}