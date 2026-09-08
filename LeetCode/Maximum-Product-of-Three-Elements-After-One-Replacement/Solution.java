1class Solution {
2    public long maxProduct(int[] nums) {
3    Arrays.sort(nums);
4    int n = nums.length;
5    long x = 100000L;
6    long ans = Long.MIN_VALUE;
7    ans = Math.max(ans, x * nums[n - 1] * nums[n - 2]);
8    ans = Math.max(ans, x * nums[0] * nums[1]);
9    ans = Math.max(ans, -x * nums[n - 1] * nums[0]);
10    ans = Math.max(ans, -x * nums[0] * nums[1]);
11    return ans;
12}
13}