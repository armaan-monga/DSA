class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int dp1 = 1, dp2 = 1, ans = 1;
        for (int i = 1; i < n; i++) {
            int n1 = 1, n2 = 1;
            if (nums1[i] >= nums1[i - 1]) n1 = Math.max(n1, dp1 + 1);
            if (nums1[i] >= nums2[i - 1]) n1 = Math.max(n1, dp2 + 1);
            if (nums2[i] >= nums1[i - 1]) n2 = Math.max(n2, dp1 + 1);
            if (nums2[i] >= nums2[i - 1]) n2 = Math.max(n2, dp2 + 1);
            dp1 = n1;
            dp2 = n2;
            ans = Math.max(ans, Math.max(dp1, dp2));
        }
        return ans;
    }
}