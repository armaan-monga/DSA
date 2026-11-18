class Solution {
    int[][] dp;
    public int minSteps(int n) {
        dp=new int[n+1][n+1];
        for(int[] v: dp){
            Arrays.fill(v,-1);
        }
        if(n==1)return 0;
       return 1 + solve(1,1,n); 
    }
    public int solve(int currA,int clipA,int n){
        if(currA==n)return 0;
        if(currA>n)return 100000;
        if(dp[currA][clipA]!=-1)return dp[currA][clipA];
        int copyAllPaste = 1+1+solve(currA+currA,currA,n);
        int paste = 1+solve(currA+clipA,clipA,n);
        return dp[currA][clipA]=Math.min(copyAllPaste,paste);
    }
}