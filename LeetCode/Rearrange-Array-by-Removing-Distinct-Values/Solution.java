1// class Solution {
2//     public int[] rearrangeArray(int[] nums) {
3//         int[] ans = new int[nums.length];
4//         Map<Integer,Integer> map = new HashMap<>();
5//         PriorityQueue<Integer> pq = new PriorityQueue<>();
6//         for(int i=0;i<nums.length;i++){
7//             map.put(nums[i],map.getOrDefault(nums[i],0)+1);
8//         }
9//         int i = 0;
10//         while(i<nums.length){
11//         for(int key : map.keySet()){
12//             if(map.get(key)>=1)
13//             pq.add(key);
14//             map.put(key,map.get(key)-1);
15//         }
16//         while(pq.size()>0){
17//             ans[i++]=pq.remove();
18//         }
19//         }
20//         return ans;
21//     }
22// }
23
24
25
26class Solution {
27    public int[] rearrangeArray(int[] nums) {
28        int[] freq = new int[101];
29        for (int ele:nums) {
30            freq[ele]++;
31        }
32        int[] arr = new int[nums.length];
33        int i=0;
34
35        while (i<nums.length) {
36            for (int j=1;j<=100;j++) {
37                if (freq[j]>0) {
38                    arr[i++] = j;
39                    freq[j]--;
40                }
41            }
42        }
43        return arr;
44    }
45}