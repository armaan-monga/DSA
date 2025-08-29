class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        if(nums[0]!=nums[1])return nums[0];
        if(nums[n-1]!=nums[n-2])return nums[n-1];
        int st=0;
        int end=nums.length-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(nums[mid]!=nums[mid+1]&&nums[mid]!=nums[mid-1])return nums[mid];
            int f=mid,s=mid;
            if(nums[mid]==nums[mid+1]) s=mid+1;
            else f=mid-1; 
            int leftcount=f-st;
            int rightcount=end-s;
            if(leftcount%2==0)st=s+1;
            else end = f-1;
        }return -1;
    }
}