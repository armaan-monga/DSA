class Solution {
public:
    vector<int> numberGame(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        vector<int> arr;
        int n=nums.size();
        for(int i=0;i<n;i+=2){
            arr.push_back(nums[i+1]);
            arr.push_back(nums[i]);
        }return arr;
    }
};