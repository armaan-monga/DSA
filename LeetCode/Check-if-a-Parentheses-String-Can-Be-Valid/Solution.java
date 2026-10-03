1class Solution {
2    public boolean canBeValid(String s, String locked) {
3        int n = s.length();
4        if (n % 2 != 0) {
5            return false;
6        }
7        int low = 0;
8        int high = 0;
9        for (int i = 0; i < n; i++) {
10            if (locked.charAt(i) == '1') {
11                if (s.charAt(i) == '(') {
12                    low++;
13                    high++;
14                } else {
15                    low--;
16                    high--;
17                }
18            } else {
19                low--;
20                high++;
21            }
22            low = Math.max(0, low);
23            if (high < 0) {
24                return false;
25            }
26        }
27        return low == 0;
28    }
29}