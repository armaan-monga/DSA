class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(0, s, sb, ans);
        return ans;
    }
    public void solve(int i, String s, StringBuilder sb, List<String> ans) {
        if (i == s.length()) {
            ans.add(sb.toString());
            return;
        }
        char ch = s.charAt(i);
        if (Character.isLetter(ch)) {
            sb.append(Character.toLowerCase(ch));
            solve(i + 1, s, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(Character.toUpperCase(ch));
            solve(i + 1, s, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(ch);
            solve(i + 1, s, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}