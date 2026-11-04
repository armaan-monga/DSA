class Solution {
    int[][] dp;
    public boolean solve(int i,int[] nums,int sum,int curr){
        if(i==nums.length){
            return curr==sum;
        }
        if(curr==sum)return true;
        if(curr>sum)return false;
        if(dp[i][curr]!=-1)return dp[i][curr]==1 ? true : false;
        boolean pick = solve(i+1,nums,sum,curr+nums[i]);
        boolean skip = solve(i+1,nums,sum,curr);
        if(pick || skip){
            dp[i][curr]=1;
            return true;
        }
        else{
            dp[i][curr]=0;
            return false;
            }
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum+=num;
        }
        if(sum%2!=0)return false;
        dp = new int[nums.length][sum];
        for(int[] v : dp){
            Arrays.fill(v,-1);
        }
        return solve(0,nums,sum/2,0);
    }
}