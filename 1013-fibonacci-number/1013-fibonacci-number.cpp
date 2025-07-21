class Solution {
public:
    int fib(int n) {
        int a=0,b=1;
         if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
};