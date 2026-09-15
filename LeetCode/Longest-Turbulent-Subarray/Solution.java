1class Solution {
2    public int maxTurbulenceSize(int[] arr) {
3        int n = arr.length;
4        if (n == 1) {
5            return 1;
6        }
7        int left = 0;
8        int prev = 0;
9        int ans = 1;
10        for (int right = 1; right < n; right++) {
11            int curr;
12            if (arr[right - 1] < arr[right]) {
13                curr = 1;
14            } else if (arr[right - 1] > arr[right]) {
15                curr = -1;
16            } else {
17                curr = 0;
18            }
19            if (curr == 0) { left = right; } else if (curr == prev) { left = right - 1; }
20            prev = curr;
21            ans = Math.max(ans, right - left + 1);
22        }
23        return ans;
24    }
25}
26
27