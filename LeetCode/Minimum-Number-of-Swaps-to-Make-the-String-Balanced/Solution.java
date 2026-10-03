1class Solution {
2    public int minSwaps(String s) {
3        int balance = 0;
4        int swaps = 0;
5        for (char ch : s.toCharArray()) {
6            if (ch == '[') {
7                balance++;
8            } else {
9                balance--;
10            }
11            if (balance < 0) {
12                swaps++;
13                balance += 2;
14            }
15        }
16        return swaps;
17    }
18}