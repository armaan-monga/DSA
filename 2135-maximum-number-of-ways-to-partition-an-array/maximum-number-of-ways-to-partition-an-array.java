class Solution {
    public int waysToPartition(int[] nums, int k) {
        int n = nums.length;
        long total = 0;
        for(int num : nums) {
            total += num;
        }
        Map<Long, Integer> left = new HashMap<>();
        Map<Long, Integer> right = new HashMap<>();
        long prefix = 0;
        for(int i = 0; i < n-1; i++) {
            prefix += nums[i];
            long diff = 2 * prefix - total;
            right.put(diff, right.getOrDefault(diff, 0) + 1);
        }
        int ans = right.getOrDefault(0L, 0);
        prefix = 0;
        for(int i = 0; i < n; i++) {
            if(i > 0) {
                long diff = 2 * prefix - total;
                right.put(diff, right.get(diff) - 1);
                if(right.get(diff) == 0) {
                    right.remove(diff);
                }
                left.put(diff, left.getOrDefault(diff, 0) + 1);
            }
            long delta = (long) k - nums[i];
            int count = left.getOrDefault(delta, 0)
                      + right.getOrDefault(-delta, 0);
            ans = Math.max(ans, count);
            prefix += nums[i];
        }

        return ans;
    }
}