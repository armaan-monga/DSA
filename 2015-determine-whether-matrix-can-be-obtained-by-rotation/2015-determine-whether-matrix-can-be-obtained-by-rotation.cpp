class Solution {
public:
    bool findRotation(vector<vector<int>>& matrix, vector<vector<int>>& target) {

        for(int rotation=0;rotation<4;rotation++){
            if(matrix==target) return true;
            rotate90(matrix);
            }
            return false;
        }
private:
        void rotate90(vector<vector<int>>& matrix){
        // firstly transpose matrix

        int n=matrix.size();
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                swap(matrix[i][j],matrix[j][i]);
            }
        }

            // then each row

        for(int i=0;i<n;i++){
            int st=0,end=n-1;
            while(st<end){
                swap(matrix[i][st],matrix[i][end]);
                st++;
                end--;
            }
        }
        }
     
};