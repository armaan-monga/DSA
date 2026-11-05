class Solution {
    int MOD = 1000000007;
    long[][] dp;

    public long solve(int i, int remaining, int[] nums) {

        if(i == nums.length) {
            return 1;
        }

        if(dp[i][remaining] != -1) {
            return dp[i][remaining];
        }

        // Skip current element
        long skip = solve(i+1, remaining, nums);

        // Pick current element
        long pick = 0;

        if(nums[i] <= remaining) {
            pick = solve(i+1, remaining-nums[i], nums);
        }

        return dp[i][remaining] = (pick + skip) % MOD;
    }

    public int countPartitions(int[] nums, int k) {

        long total = 0;

        for(int num : nums) {
            total += num;
        }

        if(total < 2L*k) return 0;

        int n = nums.length;

        dp = new long[n][k];

        for(long[] row : dp) {
            Arrays.fill(row, -1);
        }

        long bad = solve(0, k-1, nums);

        long totalWays = 1;

        for(int i = 0; i < n; i++) {
            totalWays = (totalWays * 2) % MOD;
        }

        long ans = (totalWays - 2 * bad % MOD + MOD) % MOD;

        return (int)ans;
    }
}