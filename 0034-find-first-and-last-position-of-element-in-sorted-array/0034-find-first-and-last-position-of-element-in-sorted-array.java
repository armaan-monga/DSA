class Solution {
    public static int findfirst(int[] nums,int target){
        int left=0 , right=nums.length-1;
        int ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                ans=mid;
                right = mid-1;
            }
            else if(nums[mid]<target) left=mid+1;
            else right = mid-1;
          
        }return ans;
    }

      public static int findlast(int[] nums,int target){
        int left=0 , right=nums.length-1;
        int ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                ans=mid;
                left=mid+1;
            }
            else if(nums[mid]<target) left=mid+1;
            else right = mid-1;
        }return ans;
      }

    public int[] searchRange(int[] nums, int target) {
        int first=findfirst(nums,target);
        int last=findlast(nums,target);
        return new int[]{first,last};
    }
}