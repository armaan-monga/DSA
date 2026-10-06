1class Solution {
2    double epsilon = 0.1;
3    public boolean judgePoint24(int[] cards) {
4        List<Double> nums = new ArrayList<>();
5        for(int i = 0 ; i < cards.length ; i++){
6            nums.add(1.0 * cards[i]);
7        }
8        return solve(nums);
9    }
10    public boolean solve(List<Double> nums){
11        if(nums.size() == 1){
12            return Math.abs(nums.get(0) - 24) <= epsilon; 
13        }
14        for(int i=0;i<nums.size();i++){
15            for(int j=0;j<nums.size();j++){
16                if(i==j)continue;
17                List<Double> temp = new ArrayList<>();
18                for(int k=0;k<nums.size();k++){
19                    if(k!=i && k!=j){
20                        temp.add(nums.get(k));
21                    }
22                }
23                Double a = nums.get(i);
24                Double b = nums.get(j);
25                List<Double> ops = new ArrayList<>();
26                ops.add(a + b);
27                ops.add(a - b);
28                ops.add(b - a);
29                ops.add(a * b);
30                if(Math.abs(b)>0.0){
31                    ops.add(a/b);
32                }
33                if(Math.abs(a)>0.0){
34                    ops.add(b/a);
35                }
36                for(Double val : ops){
37                    temp.add(val);
38                    if(solve(temp)==true){
39                        return true;
40                    }
41                    temp.remove(temp.size()-1);
42                }
43            }
44        }
45        return false;
46    }
47}