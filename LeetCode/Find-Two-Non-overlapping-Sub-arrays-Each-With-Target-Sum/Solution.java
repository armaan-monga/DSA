1class Solution {
2
3    public int minSumOfLengths(int[] arr, int target) {
4        Map<Integer, Integer> pos = new HashMap<>();
5        pos.put(0, -1);
6        int n = arr.length;
7        int s = 0;
8        int ans = n + 1;
9        int minL = n;
10        for (int i = 0; i < n; i++) {
11            s += arr[i];
12            if (pos.containsKey(s - target)) {
13                int j = pos.get(s - target);
14                int len = i - j;
15                ans = Math.min(ans, len + (j == -1 ? n : arr[j]));
16                minL = Math.min(minL, len);
17            }
18            arr[i] = minL;
19            pos.put(s, i);
20        }
21        return ans == n + 1 ? -1 : ans;
22    }
23}