class Solution {
    int[][] dp;
    public int solve(int n,int budget,int[][] items,int[] copies,int min){
        if(n<0){
            return budget/min;
        }
        if(dp[n][budget]!=-1)return dp[n][budget];
        int take=0;
        int price=items[n][1];
        if(price<=budget){
            take=1+copies[n]+solve(n-1,budget-price,items,copies,min);
        }
        int skip=solve(n-1,budget,items,copies,min);
        return dp[n][budget]=Math.max(take,skip);
    }
    public int maximumSaleItems(int[][] items, int budget) {
        dp=new int[1001][1501];
        for(int[] v:dp){
            Arrays.fill(v,-1);
        }
        int n=items.length;
        int[] copies=new int[n];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,items[i][1]);
            int copy=0;
            for(int j=0;j<n;j++){
                if(i==j)continue;
                if(items[j][0]%items[i][0]==0){
                    copy++;
                }
            }
            copies[i]=copy;
        }
        return solve(n-1,budget,items,copies,min);
    }
}