class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
        int left=0,right=n-1,k=n-1;
        while(left<=right){
            if(Math.abs(nums[left])>Math.abs(nums[right])){
                result[k]=nums[left]*nums[left];
                k--;left++;
            }
            else{
                result[k]=nums[right]*nums[right];
                k--;right--;
            }
        }return result;
    }
}