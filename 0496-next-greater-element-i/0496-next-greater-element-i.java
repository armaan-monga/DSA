class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums2.length;
        int[] nums=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(st.size()>0&&st.peek()<=nums2[i]){
                st.pop();
            }
            if(st.size()==0){
                nums[i]=-1;
            }
            else{
                nums[i]=st.peek();
            }
            st.push(nums2[i]);
        }
        int[] ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<n;j++){
                if(nums2[j]==nums1[i]){
                    ans[i]=nums[j];
                    break;
                }
            }
        }
        return ans;

    }
}