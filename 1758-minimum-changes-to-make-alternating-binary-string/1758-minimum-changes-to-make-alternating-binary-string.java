class Solution {
    public int minOperations(String s) {
        int n=s.length();
        int count1=0;
        int count2=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(i%2==0){
                if(ch=='0'){
                    count2++;
                }
                else count1++;
            }
            else{
                if(ch=='1'){
                    count2++;
                }
                else count1++;
            }
        }
        return Math.min(count2,count1);
    }
}