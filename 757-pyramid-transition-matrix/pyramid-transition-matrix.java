class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String,List<Character>> map = new HashMap<>();
        for(String s : allowed){
            String key = s.substring(0,2);
            char value = s.charAt(2);
            map.computeIfAbsent(key , k -> new ArrayList<>()).add(value);
        }
        StringBuilder sb = new StringBuilder();
        return solve(bottom,map,0,sb);
    }
    public boolean solve(String curr,Map<String,List<Character>> map,int idx,StringBuilder above){
        if(curr.length()==1){
            return true;
        }
        if(idx==curr.length()-1){
            return solve(above.toString(),map,0,new StringBuilder());
        }
        String pair = curr.substring(idx,idx+2);
        if(!map.containsKey(pair)){
            return false;
        }
        for(char ch : map.get(pair)){
            above.append(ch);
            if(solve(curr,map,idx+1,above)){
                return true;
            }
            above.deleteCharAt(above.length()-1);
        }
        return false;
    }
}