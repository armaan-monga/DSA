class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        HashMap<Integer,Integer> mp=new HashMap<>();
        int[] ans={-1};
        for(int i=0;i<n;i++){
            int partner=target-nums[i];
            if(mp.containsKey(partner)){
                ans=new int[]{i,mp.get(partner)};
                return ans;
            }
            else{
                mp.put(nums[i],i);
            }
        }
        return ans;
    }
}