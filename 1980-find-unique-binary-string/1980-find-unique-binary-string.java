class Solution {
    public String findDifferentBinaryString(String[] nums) {
        String result="";
        int n=nums.length;
        for(int i=0;i<n;i++){
            char ch=nums[i].charAt(i);
            result += (ch=='0') ? "1" : "0";
        }
        return result;
    }
}