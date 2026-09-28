class Solution {
    int ans = 0;
    int k;

    public int beautifulSubsets(int[] nums, int K) {
      k=K;
      HashMap<Integer,Integer> map = new HashMap<>();
      solve(0,nums,map);
      return ans-1;
    }

    public void solve(int idx,int[] nums,HashMap<Integer,Integer> map){
        if(idx==nums.length){
            ans++;
            return;
        }
        solve(idx+1,nums,map);
        if(!map.containsKey(nums[idx]+k) && !map.containsKey(nums[idx]-k)){
            map.put(nums[idx],map.getOrDefault(nums[idx],0)+1);
            solve(idx+1,nums,map);
            map.put(nums[idx],map.getOrDefault(nums[idx],0)-1);
            if(map.get(nums[idx])==0)map.remove(nums[idx]);
        }
    }
}