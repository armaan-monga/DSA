class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int n=matrix.size();
         int m=matrix[0].size();
         for(int i=0;i<n;i++){
             if(matrix[i][0]<=target && target<=matrix[i][m-1]){
             int st=0,end=m-1;
             while(st<=end){
                 int mid=st+(end-st)/2;
                 if(matrix[i][mid]==target) return 1;
                 else if(matrix[i][mid]<target){
                     st=mid+1;
                 }
                 else{
                     end=mid-1;
                 }
             }
             }
         }return 0;
    }
};