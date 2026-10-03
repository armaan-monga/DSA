1// class Solution {
2//     static final int MOD = 1000000007;
3//     int[] dp;
4//     public int countTexts(String keys) {
5//         int n=keys.length();
6//         dp=new int[n+1];
7//         dp[n]=1;
8//         for(int i=n-1;i>=0;i--){
9//             long ans = 0;
10//             ans += dp[i+1];
11//             if(i+1 < keys.length() && keys.charAt(i)==keys.charAt(i+1)){
12//             ans+=dp[i+2];
13//             }
14//             if(i+2 < keys.length() && keys.charAt(i)==keys.charAt(i+1) && keys.charAt(i)==keys.charAt(i+2)){
15//             ans+=dp[i+3];
16//         }
17//         if((keys.charAt(i)=='7' || keys.charAt(i)=='9') && i+3 < keys.length() && keys.charAt(i)==keys.charAt(i+1) && keys.charAt(i)==keys.charAt(i+2) && keys.charAt(i)==keys.charAt(i+3)){
18//             ans+=dp[i+4];
19//         }
20//         dp[i] = (int)(ans%MOD);
21//         }
22//         return dp[0];
23//     }
24//     public int solve(int i,String keys){
25//         if(i>=keys.length()){
26//             return 1;
27//         }
28//         if(dp[i]!=-1)return dp[i];
29//         long ans = 0;
30//         ans+=solve(i+1,keys);
31//         if(i+1 < keys.length() && keys.charAt(i)==keys.charAt(i+1)){
32//             ans+=solve(i+2,keys);
33//         }
34//         if(i+2 < keys.length() && keys.charAt(i)==keys.charAt(i+1) && keys.charAt(i)==keys.charAt(i+2)){
35//             ans+=solve(i+3,keys);
36//         }
37//         if((keys.charAt(i)=='7' || keys.charAt(i)=='9') && i+3 < keys.length() && keys.charAt(i)==keys.charAt(i+1) && keys.charAt(i)==keys.charAt(i+2) && keys.charAt(i)==keys.charAt(i+3)){
38//             ans+=solve(i+4,keys);
39//         }
40//         return dp[i]=(int)(ans%MOD);
41//     }
42// }
43
44
45class Solution {
46
47    static final int MOD = 1000000007;
48
49    public int countTexts(String keys) {
50
51        int n = keys.length();
52
53        // dp[n] = 1
54        long next1 = 1;  // dp[i+1]
55        long next2 = 0;  // dp[i+2]
56        long next3 = 0;  // dp[i+3]
57        long next4 = 0;  // dp[i+4]
58
59        long current = 0;
60
61        for (int i = n - 1; i >= 0; i--) {
62
63            long ans = 0;
64
65            // Take 1 digit
66            ans += next1;
67
68            // Take 2 digits
69            if (i + 1 < n &&
70                keys.charAt(i) == keys.charAt(i + 1)) {
71
72                ans += next2;
73            }
74
75            // Take 3 digits
76            if (i + 2 < n &&
77                keys.charAt(i) == keys.charAt(i + 1) &&
78                keys.charAt(i) == keys.charAt(i + 2)) {
79
80                ans += next3;
81            }
82
83            // Take 4 digits for 7 or 9
84            if ((keys.charAt(i) == '7' ||
85                 keys.charAt(i) == '9') &&
86                i + 3 < n &&
87                keys.charAt(i) == keys.charAt(i + 1) &&
88                keys.charAt(i) == keys.charAt(i + 2) &&
89                keys.charAt(i) == keys.charAt(i + 3)) {
90
91                ans += next4;
92            }
93
94            current = ans % MOD;
95
96            // Move the window
97            next4 = next3;
98            next3 = next2;
99            next2 = next1;
100            next1 = current;
101        }
102
103        return (int) next1;
104    }
105}