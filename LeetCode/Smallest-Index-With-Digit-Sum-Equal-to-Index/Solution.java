1class Solution {
2    public int smallestIndex(int[] nums) {
3       for(int i=0;i<nums.length;i++){
4        int digit = nums[i];
5        int sum = 0;
6        while(digit > 0){
7            int r = digit % 10;
8            sum += r;
9            digit /= 10;
10        }
11        if(sum == i)return i;
12       }
13       return -1;
14    }
15}