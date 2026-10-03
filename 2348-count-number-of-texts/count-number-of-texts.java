// class Solution {
//     static final int MOD = 1000000007;
//     int[] dp;
//     public int countTexts(String keys) {
//         int n=keys.length();
//         dp=new int[n+1];
//         dp[n]=1;
//         for(int i=n-1;i>=0;i--){
//             long ans = 0;
//             ans += dp[i+1];
//             if(i+1 < keys.length() && keys.charAt(i)==keys.charAt(i+1)){
//             ans+=dp[i+2];
//             }
//             if(i+2 < keys.length() && keys.charAt(i)==keys.charAt(i+1) && keys.charAt(i)==keys.charAt(i+2)){
//             ans+=dp[i+3];
//         }
//         if((keys.charAt(i)=='7' || keys.charAt(i)=='9') && i+3 < keys.length() && keys.charAt(i)==keys.charAt(i+1) && keys.charAt(i)==keys.charAt(i+2) && keys.charAt(i)==keys.charAt(i+3)){
//             ans+=dp[i+4];
//         }
//         dp[i] = (int)(ans%MOD);
//         }
//         return dp[0];
//     }
//     public int solve(int i,String keys){
//         if(i>=keys.length()){
//             return 1;
//         }
//         if(dp[i]!=-1)return dp[i];
//         long ans = 0;
//         ans+=solve(i+1,keys);
//         if(i+1 < keys.length() && keys.charAt(i)==keys.charAt(i+1)){
//             ans+=solve(i+2,keys);
//         }
//         if(i+2 < keys.length() && keys.charAt(i)==keys.charAt(i+1) && keys.charAt(i)==keys.charAt(i+2)){
//             ans+=solve(i+3,keys);
//         }
//         if((keys.charAt(i)=='7' || keys.charAt(i)=='9') && i+3 < keys.length() && keys.charAt(i)==keys.charAt(i+1) && keys.charAt(i)==keys.charAt(i+2) && keys.charAt(i)==keys.charAt(i+3)){
//             ans+=solve(i+4,keys);
//         }
//         return dp[i]=(int)(ans%MOD);
//     }
// }


class Solution {

    static final int MOD = 1000000007;

    public int countTexts(String keys) {

        int n = keys.length();

        // dp[n] = 1
        long next1 = 1;  // dp[i+1]
        long next2 = 0;  // dp[i+2]
        long next3 = 0;  // dp[i+3]
        long next4 = 0;  // dp[i+4]

        long current = 0;

        for (int i = n - 1; i >= 0; i--) {

            long ans = 0;

            // Take 1 digit
            ans += next1;

            // Take 2 digits
            if (i + 1 < n &&
                keys.charAt(i) == keys.charAt(i + 1)) {

                ans += next2;
            }

            // Take 3 digits
            if (i + 2 < n &&
                keys.charAt(i) == keys.charAt(i + 1) &&
                keys.charAt(i) == keys.charAt(i + 2)) {

                ans += next3;
            }

            // Take 4 digits for 7 or 9
            if ((keys.charAt(i) == '7' ||
                 keys.charAt(i) == '9') &&
                i + 3 < n &&
                keys.charAt(i) == keys.charAt(i + 1) &&
                keys.charAt(i) == keys.charAt(i + 2) &&
                keys.charAt(i) == keys.charAt(i + 3)) {

                ans += next4;
            }

            current = ans % MOD;

            // Move the window
            next4 = next3;
            next3 = next2;
            next2 = next1;
            next1 = current;
        }

        return (int) next1;
    }
}