class Solution {
    public long subArrayRanges(int[] nums) {
        
        long sum=0;
        for(int i=0;i<nums.length-1;i++){
            int maxi=nums[i];
            int mini=nums[i];
            for(int j=i+1;j<nums.length;j++){
                maxi=Math.max(maxi,nums[j]);
                mini=Math.min(mini,nums[j]);
                sum=sum+(maxi-mini);
            }
        }
        return sum;
    }
}