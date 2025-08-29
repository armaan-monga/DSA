class Solution {
    public int mySqrt(int n) {
        if(n==0)return n;
        int st=1;
        int end=n;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(mid==n/mid)return mid;
            else if(mid>n/mid)end=mid-1;
            else st=mid+1;
        }return end;
    }
}