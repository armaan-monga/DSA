class Solution {
public:
    bool canAliceWin(vector<int>& nums) {
         int singleSum = 0, doubleSum = 0;

    for (int num : nums) {
        if (num < 10) {
            singleSum += num;
        } else if (num < 100) {
            doubleSum += num;
        }
    }

    int totalSum = 0;
    for (int num : nums) {
        totalSum += num;
    }

    int singleRest = totalSum - singleSum;
    int doubleRest = totalSum - doubleSum;
    return (singleSum > singleRest) || (doubleSum > doubleRest);
}
};