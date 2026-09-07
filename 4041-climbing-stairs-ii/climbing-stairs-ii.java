// class Solution {
//     int[] dp;
//     public int climbStairs(int n, int[] arr) {
//         dp=new int[n+1];
//         Arrays.fill(dp,-1);
//         return solve(0,n,arr);
//     }
//     public int solve(int i,int n,int[] arr){
//         if(i>=n)return 0;
//         if(dp[i]!=-1)return dp[i];
//         int ans=Integer.MAX_VALUE;
//         for(int jump=1;jump<=3;jump++){
//             int j=i+jump;
//             if(j<=n){
//                 int curr_cost=arr[j-1]+(j-i)*(j-i);
//                 int future_cost=solve(j,n,arr);
//                 ans=Math.min(ans,curr_cost+future_cost);
//             }
//         }
//         return dp[i]=ans;
//     }
// }




class Solution {

    public int climbStairs(int n, int[] arr) {

        int[] dp = new int[n + 1];

        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {

            int ans = Integer.MAX_VALUE;

            for (int jump = 1; jump <= 3; jump++) {

                int j = i + jump;

                if (j <= n) {

                    int currCost = arr[j - 1] + (j - i) * (j - i);

                    ans = Math.min(ans, currCost + dp[j]);
                }
            }

            dp[i] = ans;
        }

        return dp[0];
    }
}