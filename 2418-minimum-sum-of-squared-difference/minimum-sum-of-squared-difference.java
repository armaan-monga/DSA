class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] arr = new int[100000+1];
        for(int i=0;i<n;i++){
            int d=Math.abs(nums1[i]-nums2[i]);
            arr[d]++;
        }
        long k = k1+k2;
        for(int currdiff=100000;currdiff>0 && k>0;currdiff--){
            long count = Math.min(arr[currdiff],k);
            arr[currdiff]-=(int)count;
            arr[currdiff-1]+=(int)count;
            k-=count;
        }
        long ans=0;
        for(int i=1;i<=100000;i++){
            ans+=(long)arr[i]*i*i;
        }
        return ans;
    }
}