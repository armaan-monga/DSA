class Solution {
    boolean[][] dp;
    // public boolean solve(int i,int[] nums,int sum,int curr){
    //     if(i==nums.length){
    //         return curr==sum;
    //     }
    //     if(dp[i][curr]!=-1)return dp[i][curr]==1 ? true : false;
    //     boolean pick = solve(i+1,nums,sum,curr+nums[i]);
    //     boolean skip = solve(i+1,nums,sum,curr);
    //     if(pick || skip){
    //         dp[i][curr]=1;
    //         return true;
    //     }
    //     else{
    //         dp[i][curr]=0;
    //         return false;
    //         }
    // }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum+=num;
        }
        if(sum%2!=0)return false;
        dp = new boolean[nums.length+1][(sum/2)+1];
        dp[0][0]=true;
        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=sum/2;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=nums[i-1]){
                    dp[i][j]=dp[i][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][sum/2];
    }
}