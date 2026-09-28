1class Solution {
2    public String evaluate(String s, List<List<String>> list) {
3        HashMap<String,String> map2 = new HashMap<>();
4        StringBuilder sb = new StringBuilder();
5        int n = s.length();
6        for(List<String> pair : list){
7            map2.put(pair.get(0),pair.get(1));
8        }
9        for(int i=0;i<n;i++){
10            char ch = s.charAt(i);
11            if(ch=='('){
12                int j = i+1;
13                while(s.charAt(j)!=')'){
14                   j++;
15                }
16                String sub=s.substring(i+1,j);
17                if(map2.containsKey(sub)){
18                    sb.append(map2.get(sub));
19                }
20                else sb.append('?');
21                i = j;
22            }
23            else sb.append(ch);
24        }
25        return sb.toString();
26    }
27}