class Solution {
    public int countCommas(int n) {
        if(n<1000)return 0;
        // int len=0;
        // int num=n;
        // while(num>0){
        //     len++;
        //     num/=10;
        // }
        // int ans=1;
        // if(len==4){
        //   ans=n-1000;  
        // }
        // if(len==5){
        //   ans=(9000)+n-10000;  
        // }
        // if(len==6){
        //   ans=(99000)+n-100000;  
        // }
        // return ans+1;
        return n-999;
    }
}

