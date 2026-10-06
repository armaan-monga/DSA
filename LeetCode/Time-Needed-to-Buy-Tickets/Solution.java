1class Solution {
2    class pair{
3        int ele;
4        int idx;
5        public pair(int ele,int idx){
6            this.ele=ele;
7            this.idx=idx;
8        }
9    }
10    public int timeRequiredToBuy(int[] arr, int k) {
11        Queue<pair> q = new LinkedList<>();
12        for(int i=0;i<arr.length;i++){
13            q.add(new pair(arr[i],i));
14        }
15        int count = 1; 
16        while(q.size()>0){
17            pair p = q.remove();
18            if(p.ele-1 == 0){
19                if(p.idx==k)return count;
20            }
21            if(p.ele-1!=0)q.add(new pair(p.ele-1,p.idx));
22            count++;
23        }
24        return count;
25    }
26}