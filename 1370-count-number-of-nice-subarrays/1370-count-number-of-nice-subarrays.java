class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int curr=0;
        int n=nums.length;
        int res=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(0,1);
        for(int i=0;i<n;i++){
            curr+=nums[i]%2;
            res+=mp.getOrDefault(curr-k,0);
            mp.put(curr,mp.getOrDefault(curr,0)+1);
        }
        return res;
    }
}