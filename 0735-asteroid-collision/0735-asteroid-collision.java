class Solution {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<a.length;i++){
            while(!st.isEmpty()&& st.peek()>0&&a[i]<0){
                int sum=st.peek()+a[i];
                if(sum<0){
                    st.pop();
                }
                else if(sum>0){
                    a[i]=0;
                }
                else{
                    st.pop();
                    a[i]=0;
                }
            }
            if(a[i]!=0){
                st.push(a[i]);
            }
        }
            int size=st.size();
            int[] arr=new int[size];
            int i=size-1;
            while(!st.isEmpty()){
                arr[i]=st.pop();
                i--;
            }
        return arr;
    }
}