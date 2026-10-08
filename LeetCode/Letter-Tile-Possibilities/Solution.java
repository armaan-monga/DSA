1class Solution {
2    public int numTilePossibilities(String tiles) {
3        int[] count = new int[26];  
4        for (char c : tiles.toCharArray()) {
5            count[c - 'A']++;
6        }
7        return dfs(count);
8    }
9
10    private int dfs(int[] count) {
11        int sum = 0;
12        for (int i = 0; i < 26; i++) {
13            if (count[i] > 0) { 
14                sum++; 
15                count[i]--;
16                sum += dfs(count); 
17                count[i]++;  
18            }
19        }
20        return sum;
21    }
22}