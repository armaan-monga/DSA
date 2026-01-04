class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
            boolean destroyed=false;
            while(!st.isEmpty() && st.peek()>0&&st.peek()<-arr[i]){
                st.pop();
            }
            if(!st.isEmpty() && st.peek()>0 && st.peek()==-arr[i]){
                st.pop();
                destroyed=true;
            }
            if(!destroyed && (st.isEmpty() || st.peek()<0)){
                st.push(arr[i]);
            }
            }
            else {
                st.push(arr[i]);
            }
        }
        int[] ans=new int[st.size()];
        int i=st.size()-1;
        while(st.size()>0){
            ans[i]=st.pop();
            i--;
        }
        return ans;
    }
}