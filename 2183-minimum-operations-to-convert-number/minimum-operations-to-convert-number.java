class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> q=new LinkedList<>();
        boolean[] vis =new boolean[1001];
        q.add(start);
        int steps=0;
        while(q.size()>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                int x=q.poll();
                if(x==goal)return steps;
                for(int num:nums){
                    int a=x+num;
                    int b=x-num;
                    int c=x^num;
                    if(a==goal || b==goal || c==goal)return steps+1;
                    if(a>=0 && a<=1000 && !vis[a]){
                        vis[a]=true;
                        q.add(a);
                    }
                    if(b>=0 && b<=1000 && !vis[b]){
                        vis[b]=true;
                        q.add(b);
                    }
                    if(c>=0 && c<=1000 && !vis[c]){
                        vis[c]=true;
                        q.add(c);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}