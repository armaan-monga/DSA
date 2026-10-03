class Solution {
    public int longestValidParentheses(String s) {
        int result = 0;
        int open = 0;
        int close = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(') open++;
            if(ch==')') close++;
            if(close>open){
                open = 0;
                close = 0;
            }
            if(open==close){
                result = Math.max(result,open+close);
            }
        }
        open = 0;
        close = 0;
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(ch=='(') open++;
            if(ch==')') close++;
            if(open>close){
                open = 0;
                close = 0;
            }
            if(open==close){
                result = Math.max(result,open+close);
            }
        }
        return result;
    }
}