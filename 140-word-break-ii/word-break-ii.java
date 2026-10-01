class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        solve(list,sb,0,s,wordDict);
        return list;
    }
    public void solve(List<String> list,StringBuilder sb,int i,String s, List<String> wordDict){
        if(i>=s.length()){
            list.add(sb.substring(0,sb.length()-1));
            return;
        }
        for(int j=i;j<s.length();j++){
            String sub=s.substring(i,j+1);
            if(wordDict.contains(sub)){
                int prevlen=sb.length();
                sb.append(sub).append(" ");
                solve(list,sb,j+1,s,wordDict);
                sb.delete(prevlen,sb.length());
            }
        }
    }
}
// yes we can memoize it using a hashmap of integer,string 