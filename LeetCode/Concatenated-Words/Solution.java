1class Solution {
2    Map<String,Boolean> map = new HashMap<>();
3    public List<String> findAllConcatenatedWordsInADict(String[] words) {
4        List<String> ans = new ArrayList<>();
5        Set<String> set = new HashSet<>();
6        for(int i=0;i<words.length;i++){
7            set.add(words[i]);
8        }
9        for(String word : words){
10            if(solve(word,set)){
11                ans.add(word);
12            }
13        }
14        return ans;
15    }
16    public boolean solve(String word,Set<String> set){
17        if(map.containsKey(word)) return map.get(word);
18        int n = word.length();
19        for(int i=0;i<n;i++){
20            String prefix = word.substring(0,i+1);
21            String suffix = word.substring(i+1);
22            if(set.contains(prefix) && set.contains(suffix)){
23                map.put(word,true);
24                return true;
25            }
26            if(set.contains(prefix) && solve(suffix,set)){
27                map.put(word,true);
28                return true;
29            }
30        }
31        map.put(word,false);
32        return false;
33    }
34}