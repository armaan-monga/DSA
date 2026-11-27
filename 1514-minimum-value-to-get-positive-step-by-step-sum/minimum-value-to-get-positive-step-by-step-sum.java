class Solution {
    public int minStartValue(int[] nums) {
       int start=1;
       int nn=1;
       boolean flag=true;
       while(flag){
       for(int i=0;i<nums.length;i++){
            int num=start+nums[i];
            start=num;
            if(num<1){
                flag=false;
                break;
            }
       } 
        if(flag==true){
        break;
       }
       else{
        flag=true;
       }
       start=nn+1;
       nn++;
       }
       return nn;
    }
}