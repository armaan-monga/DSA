class Solution {
public:
    bool isUgly(int n) {
         if (n <= 0) return false;
        
        int divisors[] = {2, 3, 5};
        
        for (int d : divisors) {
            while (n % d == 0) {
                n /= d;
            }
        }
        
        return n == 1;
    }
};