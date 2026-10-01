1class Solution {
2    public List<String> wordBreak(String s, List<String> wordDict) {
3        List<String> list=new ArrayList<>();
4        StringBuilder sb=new StringBuilder();
5        Set<String> set = new HashSet<>();
6        for(int i=0;i<wordDict.size();i++){
7            set.add(wordDict.get(i));
8        }
9        solve(list,sb,0,s,set);
10        return list;
11    }
12    public void solve(List<String> list,StringBuilder sb,int i,String s, Set<String> set){
13        if(i>=s.length()){
14            list.add(sb.substring(0,sb.length()-1));
15            return;
16        }
17        for(int j=i;j<s.length();j++){
18            String sub=s.substring(i,j+1);
19            if(set.contains(sub)){
20                int prevlen=sb.length();
21                sb.append(sub).append(" ");
22                solve(list,sb,j+1,s,set);
23                sb.delete(prevlen,sb.length());
24            }
25        }
26    }
27}
28// yes we can memoize it using a hashmap of integer,string 