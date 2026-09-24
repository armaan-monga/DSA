class Solution {
    int result = Integer.MIN_VALUE;
    int m;
    public void solve(int idx,int count,int[] resultant,int[][] requests){
        if(idx>=m){
            boolean allzero=true;
            for(int x:resultant){
                if(x!=0){
                    allzero = false;
                    break;
                }
            }
            if(allzero){
                result=Math.max(result,count);
            }
            return;
        }
        int from = requests[idx][0];
        int to = requests[idx][1];
        resultant[from]--;
        resultant[to]++;
        solve(idx+1,count+1,resultant,requests);
        resultant[from]++;
        resultant[to]--;
        solve(idx+1,count,resultant,requests);
    }
    public int maximumRequests(int n, int[][] requests) {
        m = requests.length;
        int[] resultant = new int[n];
        solve(0,0,resultant,requests);
        return result;
    }
}