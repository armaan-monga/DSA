class Solution {

    public int deleteAndEarn(int[] nums) {

        int max = 0;

        int[] points = new int[10001];

        // Calculate total points for each number
        for (int num : nums) {
            points[num] += num;
            max = Math.max(max, num);
        }

        int a = 0; // dp[i-2]
        int b = 0; // dp[i-1]

        for (int i = 1; i <= max; i++) {

            int c = Math.max(
                b,              // skip i
                points[i] + a   // take i
            );

            a = b;
            b = c;
        }

        return b;
    }
}