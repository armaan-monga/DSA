class Solution {
    public int findKthPositive(int[] nums, int k) {
     int n=nums.length;
     int low=0;
     int high=n-1;
     while(low<=high){
        int mid=low+(high-low)/2;
        int correctNo=mid+1;
        int missing=nums[mid]-correctNo;
        if(missing>=k) high=mid-1;
        else low=mid+1;
     }return low+k;
    }
}