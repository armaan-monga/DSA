class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }
        int low = 0;
        int high = 0;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    low++;
                    high++;
                } else {
                    low--;
                    high--;
                }
            } else {
                low--;
                high++;
            }
            low = Math.max(0, low);
            if (high < 0) {
                return false;
            }
        }
        return low == 0;
    }
}