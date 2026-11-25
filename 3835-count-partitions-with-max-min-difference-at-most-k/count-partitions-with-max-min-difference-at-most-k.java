class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        int mod = 1000000007;

        int[] dp = new int[n + 1];
        int[] prefix = new int[n + 1];

        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();

        dp[0] = 1;
        prefix[0] = 1;

        int left = 0;

        for(int right = 0; right < n; right++) {

            while(!maxD.isEmpty() &&
                  nums[maxD.peekLast()] < nums[right]) {
                maxD.pollLast();
            }
            maxD.offerLast(right);

            while(!minD.isEmpty() &&
                  nums[minD.peekLast()] > nums[right]) {
                minD.pollLast();
            }
            minD.offerLast(right);

            while(nums[maxD.peekFirst()] -
                  nums[minD.peekFirst()] > k) {

                if(maxD.peekFirst() == left)
                    maxD.pollFirst();

                if(minD.peekFirst() == left)
                    minD.pollFirst();

                left++;
            }
            dp[right + 1] = (prefix[right] - (left > 0 ? prefix[left - 1] : 0)+ mod) % mod;
            prefix[right + 1] = (prefix[right] + dp[right + 1]) % mod;
        }
        return dp[n];
    }
}
