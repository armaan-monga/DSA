class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            while(st.size()>0 && nums[st.peek()]<=nums[i%n]){
                st.pop();
            }
            if(st.size()==0) arr[i%n]=-1;
            else{
                arr[i%n]=nums[st.peek()];
            }
            st.push(i%n);
        }
        return arr;
    }
}