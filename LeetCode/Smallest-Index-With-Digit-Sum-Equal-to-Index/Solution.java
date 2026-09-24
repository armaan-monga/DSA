1class Solution {
2    public int smallestIndex(int[] nums) {
3       int ans = -1;
4       for(int i=0;i<nums.length;i++){
5        int digit = nums[i];
6        int sum = 0;
7        while(digit > 0){
8            int r = digit % 10;
9            sum += r;
10            digit /= 10;
11        }
12        if(sum == i)return i;
13       }
14       return ans;
15    }
16}