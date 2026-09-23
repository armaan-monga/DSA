1class Solution {
2    public int findLongestChain(int[][] pairs) {
3        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
4        int count = 0;
5        int end = Integer.MIN_VALUE;
6        for (int i = 0; i < pairs.length; i++) {
7            if (pairs[i][0] > end) {
8                count++;
9                end = pairs[i][1];
10            }
11        }
12        return count;
13    }
14}