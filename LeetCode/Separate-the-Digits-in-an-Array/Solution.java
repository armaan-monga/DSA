1class Solution {
2    public int[] separateDigits(int[] nums) {
3        List<Integer> list = new ArrayList<>();
4        Stack<Integer> st = new Stack<>();
5        for(int i=0;i<nums.length;i++){
6            int num = nums[i];
7            while(num>0){
8                int r = num%10;
9                st.push(r);
10                num/=10;
11            }
12            while(!st.isEmpty()){
13                list.add(st.pop());
14            }
15        }
16        int[] arr = new int[list.size()];
17        for(int i=0;i<arr.length;i++){
18            arr[i]=list.get(i);
19        }
20        return arr;
21    }
22}