1class Solution {
2    int[] dp;
3    public int solve(int i,String s){
4        if(i>=s.length())return 1;
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
15        dp=new int[s.length()];
16        Arrays.fill(dp,-1);
17        int ans=solve(0,s);
18        if(ans==0)return 0;
19        return ans;
20    }
21}