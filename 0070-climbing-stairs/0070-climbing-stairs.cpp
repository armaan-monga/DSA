class Solution {
public:
    int climbStairs(int n) {
      if (n <= 1) return 1;

    int one_step_before = 1;   
    int two_steps_before = 1;  
    int current_ways = 0;

    for (int i = 2; i <= n;i++) {
        current_ways = one_step_before + two_steps_before;
        two_steps_before = one_step_before;
        one_step_before = current_ways;
    }

    return one_step_before;
    }
};