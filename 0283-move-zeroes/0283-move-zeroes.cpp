class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int n=nums.size();
        int index=0;
        vector<int> news(n, 0);
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                news[index++]=nums[i];
            }
        }
        nums=news;
    }
};