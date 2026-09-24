class Solution {
    public int smallestIndex(int[] nums) {
       int ans = -1;
       for(int i=0;i<nums.length;i++){
        int digit = nums[i];
        int sum = 0;
        while(digit > 0){
            int r = digit % 10;
            sum += r;
            digit /= 10;
        }
        if(sum == i)return i;
       }
       return ans;
    }
}