class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(ans,sb,0,0,n);
        return ans;
    }
    public void helper(List<String> ans,StringBuilder sb,int open,int close,int n){
        if(sb.length()==2*n){
            ans.add(sb.toString());
            return;
        }
        if(open<n){
            sb.append("(");
            helper(ans,sb,open+1,close,n);
            sb.delete(sb.length()-1,sb.length());
        }
        if(close<open){
            sb.append(")");
            helper(ans,sb,open,close+1,n);
            sb.delete(sb.length()-1,sb.length());
        }
    }
}