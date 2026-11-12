class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int i = 1;
        int max = 1;
        while(i<nums.length){
            int count = 1;
            while(i<nums.length && nums[i-1]<nums[i]){
                count++;
                i++;
            }
            max = Math.max(max,count);
            count = 1;
            while(i<nums.length && nums[i-1]>nums[i]){
                count++;
                i++;
            }
            max = Math.max(count,max);
            while(i<nums.length && nums[i-1]==nums[i]){
                i++;
            }
        }
        return max;
    }
}