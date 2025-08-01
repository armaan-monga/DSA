class Solution {
public:
    string triangleType(vector<int>& nums) {
         int a = nums[0], b = nums[1], c = nums[2];

        // First, check if it can form a triangle
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "none";
        }

        // Then, check the type of triangle
        if (a == b && b == c) {
            return "equilateral";
        } else if (a == b || b == c || a == c) {
            return "isosceles";
        } else {
            return "scalene";
            }
    }
};