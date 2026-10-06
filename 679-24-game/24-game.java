class Solution {
    double epsilon = 0.1;
    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for(int i = 0 ; i < cards.length ; i++){
            nums.add(1.0 * cards[i]);
        }
        return solve(nums);
    }
    public boolean solve(List<Double> nums){
        if(nums.size() == 1){
            return Math.abs(nums.get(0) - 24) <= epsilon; 
        }
        for(int i=0;i<nums.size();i++){
            for(int j=0;j<nums.size();j++){
                if(i==j)continue;
                List<Double> temp = new ArrayList<>();
                for(int k=0;k<nums.size();k++){
                    if(k!=i && k!=j){
                        temp.add(nums.get(k));
                    }
                }
                Double a = nums.get(i);
                Double b = nums.get(j);
                List<Double> ops = new ArrayList<>();
                ops.add(a + b);
                ops.add(a - b);
                ops.add(b - a);
                ops.add(a * b);
                if(Math.abs(b)>0.0){
                    ops.add(a/b);
                }
                if(Math.abs(a)>0.0){
                    ops.add(b/a);
                }
                for(Double val : ops){
                    temp.add(val);
                    if(solve(temp)==true){
                        return true;
                    }
                    temp.remove(temp.size()-1);
                }
            }
        }
        return false;
    }
}