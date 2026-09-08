class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        int[] ends = new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int idx=ch-'a';
            int total=0;
            for(int count:ends){
                total=(total+count)%MOD;
            }
            ends[idx]=(total+1)%MOD;
        }
        int result=0;
        for(int count:ends)result=(result+count)%MOD;
        return result;
    }
}