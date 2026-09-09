class Solution {
    int[] dp;
    HashMap<Integer, Integer> map;
    public int solve(int i) {
        if (i <= 0) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int skip = solve(i - 1);
        int take = map.getOrDefault(i, 0) + solve(i - 2);
        return dp[i] = Math.max(skip, take);
    }
    public int deleteAndEarn(int[] nums) {
        map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + num);
            max = Math.max(max, num);
        }
        dp = new int[max + 1];
        int a =0;
        int b=0;
        int c=0;
        if (max >= 1)
        b = map.getOrDefault(1, 0);
        for(int i=2;i<=max;i++){
            c=Math.max(b,map.getOrDefault(i,0)+a);
            a=b;
            b=c;
        }
        return b;
    }
}