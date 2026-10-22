class Solution {
    public String removeTrailingZeros(String num) {
        int n=num.length();
        StringBuilder sb = new StringBuilder(num);
        // for(int i=n-1;i>=0;i++){
        //     if(sb.charAt(i)=='0'){
        //         sb.deleteCharAt(i);
        //     }
        //     else break;
        // }
        int i=n-1;
        while(sb.charAt(i)=='0'){
            sb.deleteCharAt(i);
            i--;
        }
        return sb.toString();
    }
}