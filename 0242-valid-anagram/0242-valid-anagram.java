class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        HashMap<Character,Integer> map=new HashMap<>();
        for(char key:s.toCharArray()){
            map.put(key,map.getOrDefault(key,0)+1);
        }
        for(char key:t.toCharArray()){
            if(!map.containsKey(key))return false;
            map.put(key,map.get(key)-1);
            if(map.get(key)==0)map.remove(key);
        }
        return map.isEmpty();
}
}