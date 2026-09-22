class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans=new ArrayList<>();
       solve(0,s,"",ans); 
       return ans;
    }
    public void solve(int i,String s,String temp,List<String> ans){
        if(i==s.length()){
            ans.add(temp);
            return;
        }
        char ch = s.charAt(i);
        if(Character.isLetter(ch)){
            char lower=Character.toLowerCase(ch);
            char upper = Character.toUpperCase(ch);
            solve(i+1,s,temp+lower,ans);
            solve(i+1,s,temp+upper,ans);
        }
        else{
            solve(i+1,s,temp+ch,ans);
        }
        return;
    }
}