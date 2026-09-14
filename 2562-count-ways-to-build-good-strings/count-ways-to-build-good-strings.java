class Solution {
    public int MOD=1000000007;
    int[] dp;
    public int solve(int i,int l,int h,int z,int o){
        if(i>h)return 0;
        if(dp[i]!=-1)return dp[i];
        int ans=0;
        if(i>=l)ans=1;
        int pick_z=solve(i+z,l,h,z,o);
        int pick_o=solve(i+o,l,h,z,o);
        return dp[i]=(ans+pick_z+pick_o)%MOD;
    }
    public int countGoodStrings(int l, int h, int z, int o) {
        dp=new int[h+1];
        for(int i=h;i>=0;i--){
            int ans=0;
            if(i>=l){
                ans=1;
            }
            if(i+z<=h)
            ans=(ans+dp[i+z])%MOD;
            if(i+o<=h)
            ans=(ans+dp[i+o])%MOD;
            dp[i]=ans;
        }
        return dp[0];
    }
}