class Solution {
    public int minimumCost(int[] nums) {
        int min=Integer.MAX_VALUE;
        int smin=Integer.MAX_VALUE;
        int a=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<min){
                smin=min;
                min=nums[i];
            }
            else if(nums[i]<smin){
                smin=nums[i];
            }
        }
        return a+min+smin;
    }
}