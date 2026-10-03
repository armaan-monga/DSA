class Solution {
    static final int MOD = 1000000007;
    int[] dp;
    public int countTexts(String keys) {
        dp=new int[keys.length()];
        Arrays.fill(dp,-1);
        return solve(0,keys);
    }
    public int solve(int i,String keys){
        if(i>=keys.length()){
            return 1;
        }
        if(dp[i]!=-1)return dp[i];
        long ans = 0;
        ans+=solve(i+1,keys);
        if(i+1 < keys.length() && keys.charAt(i)==keys.charAt(i+1)){
            ans+=solve(i+2,keys);
        }
        if(i+2 < keys.length() && keys.charAt(i)==keys.charAt(i+1) && keys.charAt(i)==keys.charAt(i+2)){
            ans+=solve(i+3,keys);
        }
        if((keys.charAt(i)=='7' || keys.charAt(i)=='9') && i+3 < keys.length() && keys.charAt(i)==keys.charAt(i+1) && keys.charAt(i)==keys.charAt(i+2) && keys.charAt(i)==keys.charAt(i+3)){
            ans+=solve(i+4,keys);
        }
        return dp[i]=(int)(ans%MOD);
    }
}