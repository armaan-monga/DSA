class Solution {
    public List<String> letterCombinations(String digits) {
      List<String> ans = new ArrayList<>();
        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        StringBuilder sb = new StringBuilder();
        backtrack(0,digits,sb,map,ans);
        return ans;
    }
    public void backtrack(int index,String digits,StringBuilder sb,String[] map,List<String> ans){
        if(index==digits.length()){
            ans.add(sb.toString());
            return;
        }
        String letters = map[digits.charAt(index)-'0'];
        for(char ch : letters.toCharArray()){
            sb.append(ch);
            backtrack(index+1,digits,sb,map,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}