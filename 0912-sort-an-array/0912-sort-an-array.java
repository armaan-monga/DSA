class Solution {
    public static void merge(int[] nums,int st,int mid,int end){
        int n1=mid-st+1;
        int n2=end-mid;
        int[] left=new int[n1];
        int[] right=new int[n2];
        int i,j,k;
        for(i=0;i<n1;i++) left[i]=nums[st+i];
        for(j=0;j<n2;j++) right[j]=nums[mid+1+j];
        i=0;
        j=0;
        k=st;
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                nums[k++]=left[i++];
            }
            else{
                nums[k++]=right[j++];
            }
        }
            while(i<n1){
                nums[k++]=left[i++];
            }
            while(j<n2){
                nums[k++]=right[j++];
            }
        }
    public static void mergesort(int[] nums,int st,int end){
        if(st>=end) return;
        int mid=st+(end-st)/2;
        mergesort(nums,st,mid);
        mergesort(nums,mid+1,end);
        merge(nums,st,mid,end);
    }

    public int[] sortArray(int[] nums) {
        int st=0;
        int end=nums.length-1;
        mergesort(nums,st,end);
        return nums;
    }
}