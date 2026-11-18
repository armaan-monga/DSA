class Solution {
    public int minChanges(String s) {
        char prev=s.charAt(0);
        int change=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch==prev){
                count++;
                continue;
            }
            if(count%2==0){
                count=1;
            }
            else{
                count=0;
                change++;
            }
            prev=ch;
        }
        return change;
    }
}