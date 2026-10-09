// class Solution {
//     public int[] rearrangeArray(int[] nums) {
//         int[] ans = new int[nums.length];
//         Map<Integer,Integer> map = new HashMap<>();
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         for(int i=0;i<nums.length;i++){
//             map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//         }
//         int i = 0;
//         while(i<nums.length){
//         for(int key : map.keySet()){
//             if(map.get(key)>=1)
//             pq.add(key);
//             map.put(key,map.get(key)-1);
//         }
//         while(pq.size()>0){
//             ans[i++]=pq.remove();
//         }
//         }
//         return ans;
//     }
// }



class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] freq = new int[101];
        for (int ele:nums) {
            freq[ele]++;
        }
        int[] arr = new int[nums.length];
        int i=0;

        while (i<nums.length) {
            for (int j=1;j<=100;j++) {
                if (freq[j]>0) {
                    arr[i++] = j;
                    freq[j]--;
                }
            }
        }
        return arr;
    }
}