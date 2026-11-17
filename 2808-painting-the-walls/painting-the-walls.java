class Solution {
    int[][] dp;
    public int solve(int i,int[] cost,int[] time,int remaining){
        if(remaining<=0)return 0;
        if(i>=time.length)return Integer.MAX_VALUE;
        if(dp[i][remaining]!=-1)return dp[i][remaining];
        int pick=Integer.MAX_VALUE;
        int next = solve(i+1,cost,time,remaining-1-time[i]);
        if(next!=Integer.MAX_VALUE){
            pick = cost[i]+next;
        }
        int skip = solve(i+1,cost,time,remaining);
        return dp[i][remaining]=Math.min(pick,skip);
    }
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        dp=new int[n][n+1];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return solve(0,cost,time,cost.length);
    }
}