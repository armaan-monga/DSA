class Solution {
    long[][] dp;
    public long solve(int i,int[] nums,int n,boolean isEven){
        if(i>=n)return 0;
        int state=isEven ? 1:0;
        if(dp[i][state]!=-1)return dp[i][state];
        long take;
        if(isEven)
        take = nums[i] + solve(i+1,nums,n,!isEven);
        else 
        take = -nums[i] + solve(i+1,nums,n,!isEven);
        long skip = solve(i+1,nums,n,isEven);
        return dp[i][state]=Math.max(take,skip);
    }
    public long maxAlternatingSum(int[] nums) {
        dp=new long[nums.length][2];
        for(long[] v:dp){
            Arrays.fill(v,-1);
        }
        return solve(0,nums,nums.length,true);
    }
}