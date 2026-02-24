class Solution {
    public boolean hasAllCodes(String s, int k) {
        int codes=(int)Math.pow(2,k);
        int n=s.length();
        Set<String> set=new HashSet<>();
        for(int i=k;i<=n;i++){
            String sub=s.substring(i-k,i);
            set.add(sub);
        }
        if(set.size()==codes)return true;
        return false;
    }
}