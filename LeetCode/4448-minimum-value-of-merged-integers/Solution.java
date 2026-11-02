class Solution {
    public int minMergedInteger(int[] nums) {
       int ans=Integer.MAX_VALUE;
       int n=nums.length;
        for(int i=0;i<n-1;i+=2){
            int num1 = nums[i];
            int num2 = nums[i+1];
            String s1 = String.valueOf(num1);
            String s2 = String.valueOf(num2);
            String s = s1+s2;
            int temp = Integer.parseInt(s);
            ans=Math.min(temp,ans);
        }
        return ans;
    }
}