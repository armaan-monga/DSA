class Solution {
    public String reverseWords(String s) {
        String[] arr=s.split("\\s+");
        Stack<String> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            st.push(arr[i]);
        }
        int i=0;
        while(st.size()!=0){
            arr[i]=st.pop();
            i++;
        }
        String sb=String.join(" ",arr);
        return sb.trim();
    }
}