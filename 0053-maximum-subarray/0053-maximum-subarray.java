class Solution {
    public int maxSubArray(int[] nums) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int n=nums.length;
        int maxsum=Integer.MIN_VALUE;
        int currsum=0;
        for(int i=0;i<n;i++){
            currsum+=nums[i];
            maxsum=Math.max(currsum,maxsum);
            if(currsum<0)currsum=0;
        }
        return maxsum;
    }
}