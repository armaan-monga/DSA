class Solution {
        public int solve(int i,int[] nums,int n,int[] dp){
        if(i>=n)return 0;
        if(dp[i]!=-1)return dp[i];
        int take = nums[i] + solve(i+2,nums,n,dp);
        int skip=solve(i+1,nums,n,dp);
        return dp[i]=Math.max(take,skip);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp1=new int[n];
        int[] dp2=new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[1],nums[0]);
        int first=solve(0,nums,n-1,dp1);
        int second=solve(1,nums,n,dp2);
        return Math.max(first,second);
    }
}