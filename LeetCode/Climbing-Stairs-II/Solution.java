1class Solution {
2    int[] dp;
3    public int climbStairs(int n, int[] arr) {
4        dp=new int[n+1];
5        Arrays.fill(dp,-1);
6        return solve(0,n,arr);
7    }
8    public int solve(int i,int n,int[] arr){
9        if(i>=n)return 0;
10        if(dp[i]!=-1)return dp[i];
11        int ans=Integer.MAX_VALUE;
12        for(int jump=1;jump<=3;jump++){
13            int j=i+jump;
14            if(j<=n){
15                int curr_cost=arr[j-1]+(j-i)*(j-i);
16                int future_cost=solve(j,n,arr);
17                ans=Math.min(ans,curr_cost+future_cost);
18            }
19        }
20        return dp[i]=ans;
21    }
22}