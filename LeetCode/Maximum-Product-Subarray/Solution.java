1class Solution {
2    public int maxProduct(int[] nums) {
3        int maxending=nums[0];
4        int minending=nums[0];
5        int ans=nums[0];
6        for(int i=1;i<nums.length;i++){
7            int curr=nums[i];
8            int tempmax=Math.max(curr,Math.max(curr*minending,curr*maxending));
9            int tempmin=Math.min(curr,Math.min(curr*minending,curr*maxending));
10            maxending=tempmax;
11            minending=tempmin;
12            ans=Math.max(ans,tempmax);
13        }
14        return ans;
15    }
16}