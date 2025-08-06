class Solution {
public:
    bool canJump(vector<int>& nums) {
         int maxReach = 0; // furthest index we can reach
        int n = nums.size();

        for (int i = 0; i < n; ++i) {
            if (i > maxReach) {
                // can't reach this position
                return false;
            }
            maxReach = max(maxReach, i + nums[i]);
            if (maxReach >= n - 1) {
                return true; // can reach or pass the last index
            }
        }
        return false;
    }
};