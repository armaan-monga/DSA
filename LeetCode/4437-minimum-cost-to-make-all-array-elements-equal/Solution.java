
class Solution {
    public long minCost(int[] nums) {
        int n = nums.length;
        long ans = Long.MAX_VALUE;

        int i = 0;

        while(i < n) {
            int j = i;

            while(j + 1 < n && nums[j] == nums[j+1]) {
                j++;
            }

            // Check whether this group contains
            // at least one valid interior index.
            if(i <= n-2 && j >= 1) {

                long cost = 0;

                if(i > 0) {
                    cost += (long)i * nums[i];
                }

                if(j < n-1) {
                    cost += (long)(n-j-1) * nums[i];
                }

                ans = Math.min(ans, cost);
            }

            i = j + 1;
        }

        return ans;
    }
}
