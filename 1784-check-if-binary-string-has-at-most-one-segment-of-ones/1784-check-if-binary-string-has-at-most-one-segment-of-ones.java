class Solution {
    public boolean checkOnesSegment(String s) {
        if(s.length()==1 && s.charAt(0)=='1')return true;
        int index=0;
        for(int i=1;i<s.length();i++){
            char ch1=s.charAt(i);
            char ch0=s.charAt(i-1);
            if(ch1==ch0 && ch1=='1'){
               index=i; 
            }
            if(ch1=='1' && index!=i)return false;
        }
        return true;
    }
}