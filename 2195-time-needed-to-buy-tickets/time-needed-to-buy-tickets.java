class Solution {
    class pair{
        int ele;
        int idx;
        public pair(int ele,int idx){
            this.ele=ele;
            this.idx=idx;
        }
    }
    public int timeRequiredToBuy(int[] arr, int k) {
        Queue<pair> q = new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            q.add(new pair(arr[i],i));
        }
        int count = 1; 
        while(q.size()>0){
            pair p = q.remove();
            if(p.ele-1 == 0){
                if(p.idx==k)return count;
            }
            if(p.ele-1!=0)q.add(new pair(p.ele-1,p.idx));
            count++;
        }
        return count;
    }
}