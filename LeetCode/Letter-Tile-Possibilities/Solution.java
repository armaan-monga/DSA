1class Solution {
2    Set<String> set = new HashSet<>();
3    int ans = 0;
4    public int numTilePossibilities(String tiles) {
5        StringBuilder sb = new StringBuilder();
6        boolean[] vis = new boolean[tiles.length()];
7        solve(tiles,sb,vis);
8        return set.size();
9    }
10    public void solve(String s,StringBuilder sb,boolean[] vis){
11        for(int j = 0 ; j < s.length() ; j++){
12            if(vis[j]==true) continue;
13            vis[j]=true;
14            char ch = s.charAt(j);
15            sb.append(ch);
16            set.add(sb.toString());
17            solve(s,sb,vis);
18            sb.deleteCharAt(sb.length()-1);
19            vis[j]=false;
20        }
21    }
22}