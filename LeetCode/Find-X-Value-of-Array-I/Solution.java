class Solution {
    fun resultArray(nums: IntArray, k: Int): LongArray {
        val n = nums.size
        val result = LongArray(k)
        var dp = LongArray(k)

        for (i in 0 until n) {
            val ndp = LongArray(k)
            ndp[nums[i] % k]++

            for (r in 0 until k) {
                ndp[((r.toLong() * nums[i]) % k).toInt()] += dp[r]
            }

            dp = ndp

            for (r in 0 until k) {
                result[r] += dp[r]
            }
        }

        return result
    }
}