class Solution {
    int[] dp;
    public int solve(int i,String s){
        if(i>=s.length())return 1;
        if(dp[i]!=-1)return dp[i];
        if(s.charAt(i)=='0')return 0;
        int result = solve(i+1,s);
        if(i+1<s.length())
        if(s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<='6')){
            result+=solve(i+2,s);
        }
        return dp[i]=result;
    }
    public int numDecodings(String s) {
        dp=new int[s.length()];
        Arrays.fill(dp,-1);
        int ans=solve(0,s);
        if(ans==0)return 0;
        return ans;
    }
}