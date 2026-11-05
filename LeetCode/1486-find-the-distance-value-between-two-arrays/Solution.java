class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        int n=arr1.length;
        for(int i=0;i<n;i++){
            boolean flagg = true;
            for(int j=0;j<arr2.length;j++){
                if(Math.abs(arr1[i]-arr2[j])<=d){
                    flagg = false;
                }
            }
            if(flagg)count++;
        }
        return count;
    }
}