class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int n=nums.length;
        int curr=0;
        int res=0;
        mp.put(0,1);
        for(int i=0;i<n;i++){
            curr+=nums[i];
            res+=mp.getOrDefault(curr-k,0);
            mp.put(curr,mp.getOrDefault(curr,0)+1);
        }
        return res;
    }
}