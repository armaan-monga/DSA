1class Solution {
2    public int countEven(int num) {
3        int count=0;
4        for(int i=1;i<=num;i++){
5            int sum = 0;
6            int n = i;
7            while(n>0){
8                int r=n%10;
9                sum+=r;
10                n/=10;
11            }
12            if(sum%2==0)count++;
13        }
14        return count;
15    }
16}