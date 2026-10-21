class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map= new HashMap<>();   
        for(String str:strs){
            int[] freq=new int[26];
            for(int i=0;i<str.length();i++){
                freq[str.charAt(i)-'a']++;
            }
            StringBuilder sb= new StringBuilder();
            for(int ele:freq){
                sb.append(ele).append('$');
            }
            String key=sb.toString();
            if(map.containsKey(key)){
                map.get(key).add(str);
            }
            else{
                map.put(key, new ArrayList());
                map.get(key).add(str);
            }
        }

    return new ArrayList(map.values());
    }
}