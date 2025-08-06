class Solution {
public:
    int hIndex(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int n=nums.size();
        int ans=0;
        for(int i=0;i<n;i++){
            if(n-i<=nums[i]){
                return n-i;
            }
        }
        return 0;
    }
};