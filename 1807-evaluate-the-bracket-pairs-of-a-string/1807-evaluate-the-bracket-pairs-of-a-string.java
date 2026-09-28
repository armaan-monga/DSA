class Solution {
    public String evaluate(String s, List<List<String>> list) {
        HashMap<String,String> map2 = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(List<String> pair : list){
            map2.put(pair.get(0),pair.get(1));
        }
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='('){
                int j = i+1;
                while(s.charAt(j)!=')'){
                   j++;
                }
                String sub=s.substring(i+1,j);
                if(map2.containsKey(sub)){
                    sb.append(map2.get(sub));
                }
                else sb.append('?');
                i = j;
            }
            else sb.append(ch);
        }
        return sb.toString();
    }
}