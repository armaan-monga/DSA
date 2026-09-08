1class Solution {
2    public int countCommas(int n) {
3        if(n<1000)return 0;
4        // int len=0;
5        // int num=n;
6        // while(num>0){
7        //     len++;
8        //     num/=10;
9        // }
10        // int ans=1;
11        // if(len==4){
12        //   ans=n-1000;  
13        // }
14        // if(len==5){
15        //   ans=(9000)+n-10000;  
16        // }
17        // if(len==6){
18        //   ans=(99000)+n-100000;  
19        // }
20        // return ans+1;
21        return n-999;
22    }
23}
24
25