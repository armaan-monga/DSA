class Solution {
    public String removeTrailingZeros(String num) {
        int n=num.length();
        StringBuilder sb = new StringBuilder(num);
        int i=n-1;
        while(sb.charAt(i)=='0'){
            sb.deleteCharAt(i);
            i--;
        }
        return sb.toString();
    }
}