class Solution {
    public int minStartValue(int[] nums) {
        int prefixsum=0;
        int min=0;
        for(int i=0;i<nums.length;i++){
            prefixsum+=nums[i];
            min=Math.min(prefixsum,min);
        }
        return 1-min;
    }
}