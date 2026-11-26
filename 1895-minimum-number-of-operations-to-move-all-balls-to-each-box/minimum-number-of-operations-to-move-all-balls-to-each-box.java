class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        int balls = 0;
        int cost = 0;
        for (int i = 0; i < n; i++) {
            ans[i] += cost;
            balls += boxes.charAt(i) - '0';
            cost += balls;
        }
        balls = 0;
        cost = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] += cost;
            balls += boxes.charAt(i) - '0';
            cost += balls;
        }
        return ans;
    }
}
