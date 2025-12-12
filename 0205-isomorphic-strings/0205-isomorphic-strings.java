class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<>();
        HashSet<Character> mapped=new HashSet<>();
        if(s.length()!=t.length())return false;
        for(int i=0;i<s.length();i++){
            char chs=s.charAt(i);
            char cht=t.charAt(i);
            if(map.containsKey(chs)){
                if(map.get(chs)!=cht) return false;
            }
            else{
                if(mapped.contains(cht))return  false;
                map.put(chs,cht);
                mapped.add(cht);
            }
        }
        return true;
    }
}