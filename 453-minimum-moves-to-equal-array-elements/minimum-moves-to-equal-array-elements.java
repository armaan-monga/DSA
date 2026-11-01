class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            min=Math.min(min,nums[i]);
        }
        return sum-n*min;
    }
}