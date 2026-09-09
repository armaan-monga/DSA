1class Solution {
2    long[][] dp;
3    public long helper(int i,int[] nums,boolean flag){
4        if(i<0)return 0;
5        int state=flag?1:0;
6        if(dp[i][state]!=-1)return dp[i][state];
7        long skip=helper(i-1,nums,flag);
8        int val=nums[i];
9        if(flag==false)val=-val;
10        long pick=val+helper(i-1,nums,!flag);
11        return dp[i][state]=Math.max(skip,pick);
12    }
13    public long maxAlternatingSum(int[] nums) {
14        dp=new long[nums.length][2];
15        for(long[] v:dp){
16            Arrays.fill(v,-1);
17        }
18        return helper(nums.length-1,nums,true);
19    }
20}