class Solution {
    public int findMin(int[] nums) {
        int st=0,end=nums.length-1;
        if(nums[st]<nums[end]) return nums[st];
        while(st<end){
            int mid=st+(end-st)/2;

            if(nums[mid]<nums[end]){
                end=mid;
            }

            else if(nums[mid]>nums[end]) st=mid+1;

            else end--;

        }return nums[st];
    }
}