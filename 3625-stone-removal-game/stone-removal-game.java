class Solution {
    public boolean canAliceWin(int n) {
        int alice = 10;
        int bob = 9;
        while(n>0){
            if(n-alice<0){
                return false;
            }
            n-=alice;
            alice-=2;
            if(n-bob<0){
                return true;
            }
            n-=bob;
            bob-=2;
        }
        return false;
    }
}