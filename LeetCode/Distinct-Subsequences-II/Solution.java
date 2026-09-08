1class Solution {
2    public int distinctSubseqII(String s) {
3        int MOD = 1_000_000_007;
4        int[] ends = new int[26];
5        for(int i=0;i<s.length();i++){
6            char ch=s.charAt(i);
7            int idx=ch-'a';
8            int total=0;
9            for(int count:ends){
10                total=(total+count)%MOD;
11            }
12            ends[idx]=(total+1)%MOD;
13        }
14        int result=0;
15        for(int count:ends)result=(result+count)%MOD;
16        return result;
17    }
18}