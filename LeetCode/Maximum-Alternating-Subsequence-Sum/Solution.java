1class Solution {
2    long[][] dp;
3    public long solve(int i,int[] nums,int n,boolean isEven){
4        if(i>=n)return 0;
5        int state=isEven ? 1:0;
6        if(dp[i][state]!=-1)return dp[i][state];
7        long take;
8        if(isEven)
9        take = nums[i] + solve(i+1,nums,n,!isEven);
10        else 
11        take = -nums[i] + solve(i+1,nums,n,!isEven);
12        long skip = solve(i+1,nums,n,isEven);
13        return dp[i][state]=Math.max(take,skip);
14    }
15    public long maxAlternatingSum(int[] nums) {
16        dp=new long[nums.length][2];
17        for(long[] v:dp){
18            Arrays.fill(v,-1);
19        }
20        return solve(0,nums,nums.length,true);
21    }
22}