class Solution {
    public int climbStairs(int n) {
        if(n<=2)return n;
        int a=1;
        int b=2;
        int c=0;
        for(int i=2;i<n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}



// class Solution {
//     int[] dp;
//     public int solve(int n){
//         if(n<0)return 0;
//         if(n==0)return 1;
//         if(dp[n]!=-1)return dp[n];
//         int one_step=solve(n-1);
//         int two_step=solve(n-2);
//         return dp[n]=one_step+two_step;
//     }
//     public int climbStairs(int n) {
//         dp=new int[n+1];
//         Arrays.fill(dp,-1);
//         return solve(n);
//     }
// }