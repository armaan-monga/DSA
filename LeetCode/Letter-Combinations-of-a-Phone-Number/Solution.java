1class Solution {
2    public List<String> letterCombinations(String digits) {
3      List<String> ans = new ArrayList<>();
4        String[] map = {
5            "", "", "abc", "def", "ghi",
6            "jkl", "mno", "pqrs", "tuv", "wxyz"
7        };
8        StringBuilder sb = new StringBuilder();
9        backtrack(0,digits,sb,map,ans);
10        return ans;
11    }
12    public void backtrack(int index,String digits,StringBuilder sb,String[] map,List<String> ans){
13        if(index==digits.length()){
14            ans.add(sb.toString());
15            return;
16        }
17        String letters = map[digits.charAt(index)-'0'];
18        for(char ch : letters.toCharArray()){
19            sb.append(ch);
20            backtrack(index+1,digits,sb,map,ans);
21            sb.deleteCharAt(sb.length()-1);
22        }
23    }
24}