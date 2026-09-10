class Solution {
    int[] dp;
    public int solve(int i,String s){
        if(i==s.length())return 1;
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
        int n=s.length();
        int a=0;
        int b=1;
        int c=0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='0')c=0;
            else {
            c=b;
            if(i+1<n){
            if(s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<='6')){
            c+=a;
            }
            } 
        }
        a=b;
        b=c;
        }
        return b;
    }
}