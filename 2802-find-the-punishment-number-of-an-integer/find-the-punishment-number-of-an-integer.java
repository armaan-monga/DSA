class Solution {
    public boolean solve(int idx,int sum,int target,String s){
        if(idx==s.length()){
            return sum==target;
        }
        int num = 0;
        for(int j=idx;j<s.length();j++){
            num = num*10 + (s.charAt(j)-'0');
            if(solve(j+1,sum+num,target,s))return true;
        }
        return false;
    }
    public int punishmentNumber(int n) {
        int count=0;
       for(int i=1;i<=n;i++){
        int square = i*i;
        String s  = String.valueOf(square);
        if(solve(0,0,i,s)){
            count += square;
        }
       } 
       return count;
    }
}