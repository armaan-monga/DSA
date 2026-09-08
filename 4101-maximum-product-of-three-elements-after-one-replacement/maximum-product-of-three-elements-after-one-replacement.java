class Solution {
    public long maxProduct(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    long x = 100000L;
    long ans = Long.MIN_VALUE;
    ans = Math.max(ans, x * nums[n - 1] * nums[n - 2]);
    ans = Math.max(ans, x * nums[0] * nums[1]);
    ans = Math.max(ans, -x * nums[n - 1] * nums[0]);
    ans = Math.max(ans, -x * nums[0] * nums[1]);
    return ans;
}
}