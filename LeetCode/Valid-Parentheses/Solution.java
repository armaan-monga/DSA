1class Solution {
2    public boolean isValid(String s) {
3        Stack<Character> st=new Stack<>();
4        for(char ch:s.toCharArray()){
5            if(ch=='['||ch=='{'||ch=='('){
6                st.push(ch);
7            }
8            else if(ch==')'||ch=='}'||ch==']'){
9                if(st.isEmpty())return false;
10                char top=st.pop();
11                if (ch == ')' && top != '(') return false;
12                if (ch == '}' && top != '{') return false;
13                if (ch == ']' && top != '[') return false;
14            }
15        }
16        return st.isEmpty();
17    }
18}