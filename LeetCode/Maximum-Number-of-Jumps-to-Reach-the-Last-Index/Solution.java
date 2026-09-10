1class Solution {
2    int[] dp;
3    public int solve(int i,int[] nums,int target){
4        if(i==nums.length-1)return 0;
5        if(dp[i]!=-1)return dp[i];
6        int result=-1;
7        int temp=0;
8        for(int j=i+1;j<nums.length;j++){
9            if(Math.abs(nums[i]-nums[j])<=target){
10                temp=1+solve(j,nums,target);
11                result=Math.max(result,temp);
12            }
13        }
14        return dp[i]=result==0 ? -1 : result;
15    }
16    public int maximumJumps(int[] nums, int target) {
17        int n=nums.length;
18        dp=new int[nums.length];
19        Arrays.fill(dp,-1);
20        dp[n-1]=0;
21        for(int i=n-2;i>=0;i--){
22            for (int j = i + 1; j < n; j++) {
23            if(Math.abs(nums[i]-nums[j])<=target && dp[j]!=-1){
24                dp[i]=Math.max(dp[i],1+dp[j]);
25            }
26        }
27        }
28        return dp[0];
29    }
30}