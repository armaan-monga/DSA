1class Solution {
2    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
3        int n = nums1.length;
4        int dp1 = 1, dp2 = 1, ans = 1;
5        for (int i = 1; i < n; i++) {
6            int n1 = 1, n2 = 1;
7            if (nums1[i] >= nums1[i - 1]) n1 = Math.max(n1, dp1 + 1);
8            if (nums1[i] >= nums2[i - 1]) n1 = Math.max(n1, dp2 + 1);
9            if (nums2[i] >= nums1[i - 1]) n2 = Math.max(n2, dp1 + 1);
10            if (nums2[i] >= nums2[i - 1]) n2 = Math.max(n2, dp2 + 1);
11            dp1 = n1;
12            dp2 = n2;
13            ans = Math.max(ans, Math.max(dp1, dp2));
14        }
15        return ans;
16    }
17}