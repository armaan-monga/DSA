class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int max = 0;
        Stack<Character> st = new Stack<>();
        for(int i=0;i<n;i++){
            max = Math.max(max,st.size());
            if(s.charAt(i)=='(') st.push('(');
            if(s.charAt(i)==')') st.pop();
        }
        return max;
    }
}