class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        
        int firstNonNegative = findFirstNonNegative(nums);
        int negatives = firstNonNegative; 
        int firstPositive = findFirstPositive(nums);
        int positives = n - firstPositive; 
        
        return Math.max(negatives, positives);
    }
    
    private int findFirstNonNegative(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    private int findFirstPositive(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}