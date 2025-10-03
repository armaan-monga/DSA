class Solution {
    public int findKthLargest(int[] arr, int k) {
    int n=arr.length;
//     for(int i=0;i<n;i++){
//       for(int j=i+1;j<n;j++){
//           if(arr[j]<arr[i]){
//               int temp=arr[i];
//               arr[i]=arr[j];
//               arr[j]=temp;
//           }  
//       }
//   }
Arrays.sort(arr);
    return arr[n-k];
    }
}