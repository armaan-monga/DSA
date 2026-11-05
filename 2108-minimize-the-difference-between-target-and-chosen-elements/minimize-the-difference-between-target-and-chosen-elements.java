class Solution {
    int n;
    int m;
    int[][] dp;
    public int solve(int row,int[][] mat,int target,int sum){
        if(row>=n){
            return Math.abs(target-sum);
        }
        if(dp[row][sum]!=-1)return dp[row][sum];
        int min = Integer.MAX_VALUE;
        for(int num : mat[row]){
            int ans = solve(row+1,mat,target,sum+num);
            min=Math.min(min,ans);
        }
        return dp[row][sum]=min;
    }
    public int minimizeTheDifference(int[][] mat, int target) {
        n=mat.length;
        m=mat[0].length;
        int maxsum=0;
        for(int i=0;i<n;i++){
            int max = Integer.MIN_VALUE;
            for(int num : mat[i]){
                max=Math.max(max,num);
            }
            maxsum+=max;
        }
        dp=new int[n][maxsum+1];
        for(int[] v : dp){
        Arrays.fill(v,-1);
        }
        return solve(0,mat,target,0);
    }
}