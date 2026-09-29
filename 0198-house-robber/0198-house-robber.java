class Solution {
    int[] dp;
    public int solve(int i,int[] nums){
        if(i<0)return 0;
        if(dp[i]!=-1)return dp[i];
        int take=nums[i]+solve(i-2,nums);
        int skip=solve(i-1,nums);
        return dp[i]=Math.max(take,skip);
    }
    public int rob(int[] nums) {
        if(nums.length<2)return nums[0];
        dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[nums.length-1];
    }
}