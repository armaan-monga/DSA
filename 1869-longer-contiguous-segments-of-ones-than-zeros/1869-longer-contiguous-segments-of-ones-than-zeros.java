class Solution {
    public boolean checkZeroOnes(String s) {
        int long0=0;
        int long1=0;
        int max0=0;
        int max1=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='1'){
                long1++;
                long0=0;
                max1=Math.max(max1,long1);
            }
            else{
                long0++;
                long1=0;
                max0=Math.max(max0,long0);
            }         
        }
        if(max1>max0)return true;
        return false;
    }
}