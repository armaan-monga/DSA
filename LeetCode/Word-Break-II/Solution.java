1class Solution {
2    public List<String> wordBreak(String s, List<String> wordDict) {
3        List<String> list=new ArrayList<>();
4        StringBuilder sb=new StringBuilder();
5        solve(list,sb,0,s,wordDict);
6        return list;
7    }
8    public void solve(List<String> list,StringBuilder sb,int i,String s, List<String> wordDict){
9        if(i>=s.length()){
10            list.add(sb.substring(0,sb.length()-1));
11            return;
12        }
13        for(int j=i;j<s.length();j++){
14            String sub=s.substring(i,j+1);
15            if(wordDict.contains(sub)){
16                int prevlen=sb.length();
17                sb.append(sub).append(" ");
18                solve(list,sb,j+1,s,wordDict);
19                sb.delete(prevlen,sb.length());
20            }
21        }
22    }
23}
24// yes we can memoize it using a hashmap of integer,string 