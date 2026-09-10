1class Solution {
2    int[] dp;
3    public int solve(int i,String s){
4        if(i==s.length())return 1;
5        if(dp[i]!=-1)return dp[i];
6        if(s.charAt(i)=='0')return 0;
7        int result = solve(i+1,s);
8        if(i+1<s.length())
9        if(s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<='6')){
10            result+=solve(i+2,s);
11        }
12        return dp[i]=result;
13    }
14    public int numDecodings(String s) {
15        int n=s.length();
16        int a=0;
17        int b=1;
18        int c=0;
19        for(int i=n-1;i>=0;i--){
20            if(s.charAt(i)=='0')c=0;
21            else {
22            c=b;
23            if(i+1<n){
24            if(s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<='6')){
25            c+=a;
26            }
27            } 
28        }
29        a=b;
30        b=c;
31        }
32        return b;
33    }
34}