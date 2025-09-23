class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int[] res=new int[arr.length];
        int n=arr.length;
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<n;i++){
            res[i]=-1;
        }
        for(int i=0;i<2*n;i++){
            int num=arr[i%n];
            while(st.size()>0 && arr[st.peek()]<num){
                res[st.pop()]=num;
            }
            if (i < n) { 
                st.push(i);
            }
        }
return res;
}
}