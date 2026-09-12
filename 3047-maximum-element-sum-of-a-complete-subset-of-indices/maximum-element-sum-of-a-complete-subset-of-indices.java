class Solution {
    public long maximumSum(List<Integer> A) {
    Map<Long, Long> map = new HashMap<>();
    long ans = 0;
    for (int i = 0; i < A.size(); i++) {
        long x = i + 1;
        for (long j = 2; j * j <= x; j++) {
            while (x % (j * j) == 0) {
                x /= j * j;
            }
        }
        long sum = map.getOrDefault(x, 0L);
        sum += A.get(i);
        map.put(x, sum);
        ans = Math.max(ans, sum);
    }
    return ans;
}
}