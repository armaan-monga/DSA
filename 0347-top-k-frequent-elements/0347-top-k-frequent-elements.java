class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      Map<Integer,Integer> map=new HashMap<>();
      int[] ans=new int[k];
      for(int i=0;i<nums.length;i++){
        map.put(nums[i],map.getOrDefault(nums[i],0)+1);
      }
      for(int i=0;i<k;i++){
        int maxkey=0;
        int maxfreq=-1;
        for(int key:map.keySet()){
            if(map.get(key)>maxfreq){
                maxfreq=map.get(key);
                maxkey=key;
            }
        }
        ans[i]=maxkey;
        map.put(maxkey,-1);
      }
        return ans;
    }
}