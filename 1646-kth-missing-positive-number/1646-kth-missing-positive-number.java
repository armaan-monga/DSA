class Solution {
    public int findKthPositive(int[] nums, int k) {
        int n=nums.length;
        int st=0;
        int end=n-1;
       while(st<=end){

            int mid=st+(end-st)/2;
            int missing=nums[mid]-(mid+1);
            if(k>missing) st=mid+1;
            else end=mid-1;
            
        }return st+k;
    }
}