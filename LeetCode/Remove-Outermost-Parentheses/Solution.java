1class Solution {
2    public String removeOuterParentheses(String s) {
3        Stack<Character> st=new Stack<>();
4        StringBuilder ans=new StringBuilder();
5        for(int i=0;i<s.length();i++){
6            char ch=s.charAt(i);
7            if(ch=='('){
8                if(!st.isEmpty()){
9                    ans.append(ch);
10                }
11               st.push(ch);
12            }
13            else{
14                st.pop();
15                if(!st.isEmpty()){
16                    ans.append(ch);
17                }
18                
19            }
20        }
21        return ans.toString();
22    }
23}