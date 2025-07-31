class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        // int n=matrix.size();
        //  int m=matrix[0].size();
        //  for(int i=0;i<n;i++){
        //      if(matrix[i][0]<=target && target<=matrix[i][m-1]){
        //      int st=0,end=m-1;
        //      while(st<=end){
        //          int mid=st+(end-st)/2;
        //          if(matrix[i][mid]==target) return 1;
        //          else if(matrix[i][mid]<target){
        //              st=mid+1;
        //          }
        //          else{
        //              end=mid-1;
        //          }
        //      }
        //      }
        //  }return 0;

        int n = matrix.size();
        int m = matrix[0].size();
        int row = 0, col = m - 1;  // Start from top-right

        while (row < n && col >= 0) {
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] > target)
                col--;
            else
                row++;
        }
        return false;
    }
};