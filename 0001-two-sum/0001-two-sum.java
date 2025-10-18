class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            int partner=target-nums[i];
            if(mp.containsKey(partner)){
                return new int[]{i,mp.get(partner)};
            }
            else{
                mp.put(nums[i],i);
            }
        }
        return new int[]{};
    }
}