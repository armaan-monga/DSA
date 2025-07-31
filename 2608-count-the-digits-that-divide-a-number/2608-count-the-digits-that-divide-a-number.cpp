class Solution {
public:
    int countDigits(int n) {
        int count =0;
        int original=n;
        while(n>0){
            int r=n%10;
            n/=10;
            if(original%r==0){
                count++;
            }
        }
        return count;
    }
};